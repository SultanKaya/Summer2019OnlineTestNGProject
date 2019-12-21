package tests.vytrack;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import tests.utils.Driver;

// we write extends TestBase to inherit @before and @after methods
//this class will be dedicated to tests related to Login page only
//we don't have to find elements here
//we should find elements in page classes only

public class LoginTests extends TestBase {

@Test(description= "verify that page title is 'Dashboard'")
    public void test1(){

    //create page object
    LoginPage loginPage=new LoginPage();

    //call login method,provide username and password
    loginPage.login("storemanager85","UserUser123");
    //verification stage
    //Driver.get()= return webdriver object

    WebDriverWait wait= new WebDriverWait(Driver.get(),10);
    //this is an explicit wait
    //it waits until title is 'dashboard '
   // this is not a desirable wait method inside the here, we should keep this in utils , we will improve it later
    wait.until(ExpectedConditions.titleIs("dashboard"));
    Assert.assertEquals(Driver.get().getTitle(),"Dashboard");
}






}
