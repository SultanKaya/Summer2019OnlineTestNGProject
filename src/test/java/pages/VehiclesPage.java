package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.utils.BrowserUtils;

public class VehiclesPage extends BasePage {

   @FindBy (css="[title='Create Car']")
    public WebElement createCarElement;


    /**
     * Use this method to clik on "Create a car" button
     * Method already contains waits to handle synchronization issues
     *
     */
    public void clickToCreateACar(){
       BrowserUtils.waitForVisibility(createCarElement,10);
       BrowserUtils.waitForClickablility(createCarElement,10);
       createCarElement.click();

   }






}
