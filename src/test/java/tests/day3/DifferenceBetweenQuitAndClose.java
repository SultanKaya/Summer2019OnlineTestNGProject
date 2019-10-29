package tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferenceBetweenQuitAndClose {
    public static void main (String [] args) throws  InterruptedException {
      WebDriverManager.chromedriver().setup();
        ChromeDriver driver =new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(4000);  //will pause execution for 4 seconds
  //driver.close();   // will close only one tab

        driver.quit();  // to shutdown entire browser
        //if tab only one, close () will shutdown browser
        //and we cannot use driver anymore
        // so we have to recreate an object of webdriver
        //what will happened , if I will call driver again
        //after quit()?
        driver.get("http://google.com");

    }


}
