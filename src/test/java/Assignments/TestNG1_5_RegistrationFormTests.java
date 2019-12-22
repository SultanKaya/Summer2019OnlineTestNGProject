package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.utils.BrowserFactory;
import tests.utils.BrowserUtils;

import java.util.List;

 class Tests_1to5 {
    private WebDriver driver;

    @BeforeMethod(description = "set up the before method")
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
    }

    @Test(description = "verify that warning message matches")
    public void test1() {

        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        WebElement ActualWarningMessage = driver.findElement(By.xpath("//*[text()='The date of birth is not valid']"));
        Assert.assertTrue(ActualWarningMessage.isDisplayed(),"message is not visible");
    }

    @Test(description = "Verify that following options for programming languages are displayed: c++, java, JavaScript")
    public void test2() {
        String result="";
        List<WebElement> options=driver.findElements(By.cssSelector("[class='form-check form-check-inline']"));
        for(WebElement each:options){
            result+=each.getText()+",";
        }
        result=result.substring(0,result.length()-1);
        System.out.println(result);
        Assert.assertEquals(result,"C++,Java,JavaScript","languages are wrong");

    }

    @Test(description = "verify that first name warning message long ")
    public void test3() {
        driver.findElement(By.cssSelector(".form-control")).sendKeys("a");
        WebElement message=driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(message.isDisplayed(),"message is not displayed");
        String actualMessage =message.getText();
        String expectedMessage = "first name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actualMessage, expectedMessage, "Message is not matching");
    }

    @Test(description = "verify last name warning message")
    public void test4(){
        driver.findElement(By.name("lastname")).sendKeys("b");
        WebElement message=driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(message.isDisplayed(),"message is not displayed");
        String actualMessage=message.getText();
        String expectedMessage="The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actualMessage,expectedMessage,"Message is not matching");
    }
    @Test(description = "verify the success message")
    public void test5(){
        driver.findElement(By.name("firstname")).sendKeys("Filiz");
        driver.findElement(By.name("lastname")).sendKeys("Coskunuzer");
        driver.findElement(By.xpath("//input[@placeholder='username']")).sendKeys("Filizsi");
        driver.findElement(By.xpath("//input[@data-bv-field='email']")).sendKeys("email@gmail.com");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@placeholder='571-000-0000']")).sendKeys("617-867-4536");
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.name("birthday")).sendKeys("04/08/1978");

        WebElement states=driver.findElement(By.cssSelector("select[class='form-control selectpicker']"));
        Select select=new Select(states);
        select.selectByValue("DA");

        WebElement jobTitle=driver.findElement(By.cssSelector("select[name='job_title']"));
        Select selectJob=new Select(jobTitle);
        selectJob.selectByVisibleText("SDET");
        BrowserUtils.wait(1);

        driver.findElement(By.cssSelector("#inlineCheckbox2")).click();
        BrowserUtils.wait(1);

        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        BrowserUtils.wait(1);

        String expected="You've successfully completed registration!";
        String actual=driver.findElement(By.xpath("html/body/div/div/div/div/div/p")).getText();
        Assert.assertEquals(actual,expected,"message is wrong");




    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}