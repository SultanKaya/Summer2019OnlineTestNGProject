package tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {

    public static void main(String[] args) {
//we have to set up  webdriver based on the browser that we are going to use
        WebDriverManager.chromedriver().setup();
        //we need to create an object of appopriate class
        ChromeDriver driver = new ChromeDriver();

        //let's open google.com
        //.get() method allows to open some website

        driver.get("http://google.com");

        // to read title, there is method  .getTitle()

        // test 1. verify that title of the page is a :Google
        String actualResult= driver.getTitle();
        String expectedResult= "Google";

        if (actualResult.equals(expectedResult)){
          System.out.println("Test passed");
        }
        else
          System.out.println("Test failed") ;
 //to close driver
        //at the end of test execution
        //if we opened a gate we need to close it
        driver.close();
















    }
    }

