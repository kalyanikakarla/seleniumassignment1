package PageClasses;

import Actions.SeleniumActions;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ShippingAdressPage {
    private WebDriver driver;
    public SeleniumActions actions;
    public JavascriptExecutor jse;
    public ShippingAdressPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver=driver;
        actions=new SeleniumActions(driver);
        jse=(JavascriptExecutor) driver;
    }
    @FindBy(xpath = "//button[@type='button']/span[text()='New Address']")
    WebElement newAdressLink;
    @FindBy(xpath="//input[@name='company']")
    WebElement companyInputBox;
    @FindBy(xpath = "//select[@name='region_id']")
    WebElement regiondrp;
    @FindBy(xpath = "//input[@name='postcode']")
    WebElement zipcodeInputBox;
    @FindBy(xpath="//select[@name='country_id']")
    WebElement countrydrp;
    @FindBy(xpath = "//input[@name='telephone']")
    WebElement phoneNumberInputBox;
    @FindBy(xpath="//table[@class='table-checkout-shipping-method']/tbody/tr[1]/td[1]/input[@class='radio']")
    WebElement radioButton;
    @FindBy(xpath = "//fieldset[@class='field street admin__control-fields required']/descendant::div[@class='field _required _error']/label/following-sibling::div/input")
    WebElement streetAdressInputBox;
    @FindBy(xpath = "//input[@name='city']")
    WebElement cityInputBox;
    @FindBy(xpath="//span[text()='Ship here']/parent::button")
    WebElement shiphearButton;
    @FindBy(xpath="//span[text()='Next']/parent::button")
    WebElement nextButton;
    public void shippingAdressdata() throws InterruptedException {
Thread.sleep(3000);
        jse.executeScript("arguments[0].click();",newAdressLink);
        actions.selectValueFromDropDown(regiondrp,"Indiana","value");
       // actions.selectValueFromDropDown(countrydrp,"India","value");
       // actions.clickOnElement(shiphearButton);
       // actions.clickOnElement(nextButton);
    }

    /**
     * reading data from jsonfile
     * @throws FileNotFoundException
     */

    public void readingFileFromJson() throws FileNotFoundException {

            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = (JsonObject) jsonParser.parse(new FileReader("src/test/java/TestData/Jsonfile.json"));
            String company = String.valueOf(jsonObject.get("Company"));
            String streetaddress = String.valueOf(jsonObject.get("StreetAddress"));
            String city = String.valueOf(jsonObject.get("City"));
            String postalCode = String.valueOf(jsonObject.get("Zip/Postal"));
            String phonenumber = String.valueOf(jsonObject.get("PhoneNo"));
            actions.clickOnElement(shiphearButton);
            actions.clickOnElement(nextButton);
        }






    }






