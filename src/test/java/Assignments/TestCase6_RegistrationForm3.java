package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import tests.utils.BrowserFactory;
import tests.utils.BrowserUtils;

public class TestCase6_RegistrationForm3 {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.navigate().to("http://practice.cybertekschool.com/");
        BrowserUtils.wait(3);

        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtils.wait(4);

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("user");
        BrowserUtils.wait(4);

        String message = driver.findElement(By.partialLinkText("The username must be more than 6 and less")).getText();
        String expectedMessage = ("The username must be more than 6 and less than 30 characters long");
        Assert.assertEquals(message, expectedMessage);
        System.out.println();

        driver.quit();


    }


}
