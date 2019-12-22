package Assignments;

import com.sun.tools.javac.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.TestBase;
import tests.utils.BrowserUtils;

public class TestNG1_5_RegistrationFormTests {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver.get("chrome");
        driver.navigate().to("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("registration Form")).click();
        BrowserUtils.wait(5);


    }

    @Test(description = "")
    public void Test1() {
        driver.findElement(By.cssSelector("//*[@data-bv-field='birthday']")).sendKeys("384764267");
        BrowserUtils.wait(5);
        String actualMessage = driver.findElement(By.xpath("//small[@data-bv-for='birthday'][2]")).getText();
        String expectedMessage = "The date of birth is not valid";

        Assert.assertEquals(actualMessage, expectedMessage, "Warning message is not correct");

    }

    @Test
    public void Test2() {
        List<WebElement> languages = driver.findElements(By.xpath("//*[@class='form-group'][3]")).
        for (WebElement language : languages) {
            System.out.println("Displayed language: " + language.getText());

        }
    }


    @Test
    public void Test3() {
        driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("y");
        BrowserUtils.wait(5);
        String actualMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters']")).getText();
        BrowserUtils.wait(5);
        String expectedMessage = "first name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actualMessage,expectedMessage,"Warning message are not displayed");

    }


    @Test
public void Test4(){

  driver.findElement(By.cssSelector("[placeholder='last name']")).sendKeys("x");
  BrowserUtils.wait(5);
 String actualMessage= driver.findElement(By.xpath("//small[text()='The last name can only consist of alphabetical letters and dash']")).getText();
String expectedMessage="The last name must be more than 2 and less than 64 characters long";
Assert.assertEquals(actualMessage,expectedMessage,"Warning messages is not correct");

}
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
