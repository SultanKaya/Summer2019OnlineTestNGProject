package tests.utils;

import org.openqa.selenium.WebDriver;

public class navigationPractice {


    public static void main(String[]args){
        // create webdriver object , to work with browser
        WebDriver driver = BrowserFactory.getDriver("chrome");
      driver.manage().window().maximize(); // to maximize browser window
      driver.get("http://google.com");
        //wait 3 seconds , this is custom method
        //since the method is static we use class name to call the method
//as a parameter, we provide number of seconds (time in seconds)
       // BrowserUtils.wait(3);

     //   HOW TO PRINT PAGE TITLE ??
      System.out.println(driver.getTitle());

      driver.navigate().to("http://amazon.com");

      //navigate back to google(previous URL)
        driver.navigate().back();
        //move forward to the amazon again
        driver.navigate().forward();
        //to refresh webpage /web site
        driver.navigate().refresh();
        // shutdown browser
        driver.quit();

    }
}
