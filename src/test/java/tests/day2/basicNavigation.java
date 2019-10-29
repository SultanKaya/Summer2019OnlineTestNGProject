package tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class basicNavigation {
 public static void main (String []args){
 // if you have exception error : cannot load a class
      //that means that  package name  doesn't match with location of class itself

     WebDriverManager.chromedriver().setup();
     ChromeDriver driver = new ChromeDriver ();

     // to maximize browser
     driver.manage().window().maximize();
driver.get("http://google.com");

// we want to navigate  to the different page
     // wihtin same brovser
     //we not gonna open new browser or new tab
     //URL can be passe as an object
     // we use string
     driver.navigate().to("http://amazon.com");
     // if i wan to come back  to the previous page
     driver.navigate().back();
     // if i want to know URL of current website
     String url = driver.getCurrentUrl();
     System.out.println(url);

     //selenium cannot close browser automatically
     //for this, we use method close()
     driver.quit();


 }
}
