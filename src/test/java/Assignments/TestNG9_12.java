package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.utils.BrowserFactory;

public class TestNG9_12 {

    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();
    }
    @Test(description = "Verify that following message is displayed: “This page returned a 200 status code”")
    public void test9(){
        driver.findElement(By.linkText("200")).click();
        String actual=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/p")).getText();
        //*[@id="content"]/div/p/text()[1]
        System.out.println(actual);
        String expected="This page returned a 200 status code.";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test(description = "Verify that following message is displayed: “This page returned a 301 status code”")
    public void test10(){
        driver.findElement(By.linkText("301")).click();
        String actualMessage=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/p")).getText();
        String expectedMessage="This page returned a 301 status code.";
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test(description = "Verify that following message is displayed: “This page returned a 404 status code”")
    public void test11() {
        driver.findElement(By.linkText("404")).click();
        String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/p")).getText();
        String expected = "This page returned a 404 status code.";
        Assert.assertTrue(actual.contains(expected));
    }
    @Test(description = "Verify that following message is displayed: “This page returned a 500 status code”")
    public void test12(){
        driver.findElement(By.linkText("500")).click();
        String actual=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/p")).getText();
        String expected="This page returned a 500 status code.";
        Assert.assertTrue(actual.contains(expected));
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
