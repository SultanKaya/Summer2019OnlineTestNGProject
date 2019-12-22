package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import tests.utils.BrowserFactory;
import tests.utils.BrowserUtils;

public class TestNG_8 {
    /**
     * Test case #8 Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     * Step 2. And click on “Autocomplete”.
     * Step 3. Enter “United States of America” into country input box.
     * Step 4. Verify that following message is displayed: “You selected: United States of America"
     *
     */

private WebDriver driver;

    public class Test8 {
        private WebDriver driver;

        @Test(description = "Verify that following message is displayed: “You selected: United States of America”")
        public void test8() {
            driver = BrowserFactory.getDriver("chrome");
            driver.get("https://practice-cybertekschool.herokuapp.com/");
            driver.findElement(By.linkText("Autocomplete")).click();
            //enter the country
            driver.findElement(By.cssSelector("#myCountry")).sendKeys("United States of America");
            //click the submit key
            driver.findElement(By.cssSelector(".btn.btn-primary")).click();
            //verify the message
            String actual = driver.findElement(By.cssSelector("#result")).getText();
            String expected = "You selected: United States of America";
            Assert.assertEquals(actual, expected, "Message is wrong");
        }

        @AfterMethod
        public void teardown() {
            driver.quit();
        }


    }}
