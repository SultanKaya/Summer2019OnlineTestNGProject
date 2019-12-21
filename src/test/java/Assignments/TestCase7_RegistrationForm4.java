package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import tests.utils.BrowserFactory;
import tests.utils.BrowserUtils;

public class TestCase7_RegistrationForm4 {
    public static void main(String[] args) {


        WebDriver driver= BrowserFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/");
        BrowserUtils.wait(5);

        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtils.wait(5);
        driver.findElement(By.cssSelector("[placeholder='username']")).sendKeys("user");
        BrowserUtils.wait(4);
        String message = driver.findElement(By.xpath("//small[text()='The username must be more than 6 and less " +
                "than 30 characters long']")).getText();
        String expectedMessage = "The username must be more than 6 and less than 30 characters long";
        Assert.assertEquals( expectedMessage, message);

        driver.quit();











    }

}
