package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import tests.utils.BrowserFactory;
import tests.utils.BrowserUtils;

public class TestNG_6 {
    /*
Test case #6 Step 1. Go to "https://www.tempmailaddress.com/"
Step 2. Copy and save email as a string.
Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
Step 4. And click on “Sign Up For Mailing List".
Step 5. Enter any valid name.
Step 6. Enter email from the Step 2.
Step 7. Click Sign Up
Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
Step 9. Navigate back to the “https://www.tempmailaddress.com/”
Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
Step 11. Click on that email to open it.
Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”

     */ private WebDriver driver;

    @Test
    public void test6() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com/");
        BrowserUtils.wait(2);
        WebElement email = driver.findElement(By.id("email"));
        BrowserUtils.wait(2);
        String email1 = email.getText();

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.cssSelector("input[name='full_name']")).sendKeys("Filiz");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email1);
        BrowserUtils.wait(1);
        driver.findElement(By.cssSelector("button[class='radius']")).click();
        BrowserUtils.wait(2);
        String actualMessage = driver.findElement(By.cssSelector("h3[name='signup_message']")).getText();
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(actualMessage, expectedMessage, "message is not matching");

        driver.navigate().to("https://www.tempmailaddress.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//*[@data-href='2']")).click();
        BrowserUtils.wait(2);
        WebElement emailRespond = driver.findElement(By.id("odesilatel"));
        String actualrespond = emailRespond.getText();

        String expectedRespond = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualrespond, expectedRespond);

        WebElement subject = driver.findElement(By.id("predmet"));
        String actualSubject = subject.getText();

        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actualSubject, expectedSubject);


    }





    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
