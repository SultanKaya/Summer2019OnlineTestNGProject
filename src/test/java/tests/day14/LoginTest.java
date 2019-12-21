package tests.day14;

import org.testng.annotations.Test;
import tests.TestBase;
import tests.utils.BrowserUtils;
import tests.utils.ConfigurationReader;
import tests.utils.Driver;

import java.sql.SQLOutput;

public class LoginTest extends TestBase {
@Test
public void test1(){
    //read url value from the properties file

    String url = ConfigurationReader.getProperty("url");
    //Driver.get() --> will return webdriver object
    //and then we can call webdriver methods like get(), findElement()....
    Driver.get().get(url);
    BrowserUtils.wait(2);
    Driver.close();
}
@Test
public void test2(){
    System.out.println(Driver.get().getTitle());
BrowserUtils.wait(2);

}

}
