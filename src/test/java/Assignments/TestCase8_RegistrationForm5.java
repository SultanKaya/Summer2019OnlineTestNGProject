package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import tests.utils.BrowserFactory;
import tests.utils.BrowserUtils;

public class TestCase8_RegistrationForm5 {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/");
        BrowserUtils.wait(5);

        driver.findElement(By.xpath("//*[@href='/registration_form']")).click();
        driver.findElement(By.cssSelector("[placeholder='571-000-0000']")).sendKeys("5711234354");
        BrowserUtils.wait(5);
        String message = driver.findElement(By.xpath("//small[(text()='Phone format is not correct')]")).getText();
        String expectedMessage = "Phone format is not correct";
        Assert.assertEquals(message, expectedMessage);

        driver.quit();


    }


}
