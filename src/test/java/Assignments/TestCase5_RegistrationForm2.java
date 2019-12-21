package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import tests.utils.BrowserFactory;
import tests.utils.BrowserUtils;

public class TestCase5_RegistrationForm2 {

    public static void main(String[] args) {


      WebDriver driver= BrowserFactory.getDriver("chrome");

        driver.navigate().to("http://practice.cybertekschool.com/");
        BrowserUtils.wait(1);
        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtils.wait(1);
        driver.findElement(By.cssSelector("[placeholder='last name']")).sendKeys("123");
        BrowserUtils.wait(2);
        String message = driver.findElement(By.xpath("//small[text()='The last name can only consist of alphabetical letters and dash']")).getText();
        String expectedMessage = "The last name can only consist of alphabetical letters and dash";
        Assert.assertEquals(expectedMessage, message);
        driver.quit();












    }


}
