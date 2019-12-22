package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.utils.BrowserFactory;
import tests.utils.BrowserUtils;

public class TestNG_7 {
/**
 * Test case #7 Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
 * Step 2. And click on “File Upload".
 * Step 3. Upload any file with .txt extension from your computer.
 * Step 4. Click “Upload” button.
 * Step 5. Verify that subject is: “File Uploaded!”
 * Step 6. Verify that uploaded file name is displayed.
 * Note: use element.sendKeys(“/file/path”) with specifying path to the file for uploading.
 * Run this method against “Choose File” button.
 *
 */
private WebDriver driver;

    @Test(description = "Verify that uploaded file name is displayed.")
    public void test7() {
        driver = BrowserFactory.getDriver("chrome");
        //go to the web page
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //click the file upload page
        driver.findElement(By.linkText("File Upload")).click();
        BrowserUtils.wait(2);
        //upload the file from desktop
        driver.findElement(By.cssSelector("#file-upload")).sendKeys("/Users/jdfhfuyb/rfk.txt");
        //click on the submit key
        driver.findElement(By.cssSelector("#file-submit")).click();
        //verify the message is right
        String actual = driver.findElement(By.xpath("//*[text()='File Uploaded!']")).getText();
        String expected = "File Uploaded!";
        Assert.assertEquals(actual, expected, "message is wrong");

        //verify the uploaded file name
        String expectedFilename = "FlipgridQuestions.txt";
        String actualFileName = driver.findElement(By.cssSelector("#uploaded-files")).getText();
        Assert.assertEquals(actualFileName,expectedFilename,"file name is wrong");

    }
    public void teardown(){
        driver.quit();
    }
}


