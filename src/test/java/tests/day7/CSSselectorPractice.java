package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.utils.BrowserFactory;
import tests.utils.BrowserUtils;

import java.util.List;

public class CSSselectorPractice {
    public static void main(String[] args) {

      //which locator to use ?
      //1-id    2- CSS     3-     xpath

        WebDriver  driver = BrowserFactory.getDriver("chrome");

driver.get("http://practice.cybertekschool.com/multiple_buttons");

//let's find all buttons   and click on them one by one
        //why I put .(dot) instead space ? because it's 2 class names    .btn.btn-primary
//in this case . we will find all buttons that have ;  class="btn.btn-primary"
        //or like this [class='btn btn-primary'], no need for   .(dot)
        //#  means id

List<WebElement> buttons= driver.findElements((By.cssSelector(".btn.btn-primary")));

for (WebElement button:buttons) {
    //and click on every button one by one
    button.click();
    BrowserUtils.wait(1);

    //get the message after click
    WebElement message = driver.findElement(By.cssSelector("#result"));
    //print those text one by one
    System.out.println(message.getText());
}
    //find element with a tag name h3, that has a parernt element ,with class name container
    WebElement header = driver.findElement(By.cssSelector(".container>h3"));
    System.out.println(header.getText());

    WebElement p= driver.findElement(By.cssSelector("[class='container']>p"));
        System.out.println(p.getText());

driver.quit();
    }
}
