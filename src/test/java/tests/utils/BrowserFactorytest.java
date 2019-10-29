package tests.utils;

import org.openqa.selenium.WebDriver;

public class BrowserFactorytest {
   public static void main (String []args){
       // now we can get webdriver like this
       //getDriver() method will return webdriver object
       //and we can reference variable to work with that object
      WebDriver driver = BrowserFactory.getDriver ("chrome");
      driver.get("http://practice.cybertekschool.com");
      //how we can print a source code of the page?
       System.out.println(driver.getPageSource());
       // to finish test execution
       driver.quit();



   }



}
