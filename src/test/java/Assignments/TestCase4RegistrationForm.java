package Assignments;

import bsh.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.utils.BrowserFactory;
import tests.utils.BrowserUtils;

public class TestCase4RegistrationForm {

    public static void main(String[] args) {
        /*
        cybertekschool.herokuapp.com
        Step 2. Click on “Registration Form”
        Step 3. Enter “5711234354” into phone number input box.Step 4.
         Verify that warning message is displayed: “Phone format is not correct
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.navigate().to("http://practice.cybertekschool.com/");
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtils.wait(3);

        driver.findElement(By.cssSelector("[placeholder='first name']")).sendKeys("123");
        BrowserUtils.wait(3);

        String message = driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']")).getText();
        BrowserUtils.wait(2);
        String expectedMessage = "First name can only consist of alphabetical letters";
        if (message.equals(expectedMessage)) {
            System.out.println(message + " is displayed");
        } else {
            System.out.println("failed");
        }
        driver.quit();


    }

}
