package PageClasses;

import Actions.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
    private WebDriver driver;
    public SeleniumActions actions;
    JavascriptExecutor jse;
    public WishListPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver=driver;
        actions=new SeleniumActions(driver);
        jse=(JavascriptExecutor)driver;
    }

    @FindBy(xpath = "//span[text()='You have no items in your wish list.']")
    WebElement errorMsg;
    @FindBy(xpath = "//div[@data-block='minicart']")
    WebElement addtocart;

    /**
     * retur the item name on wish list to testclass
     * @return
     */
    public String verifyingWishListPage()
    {

String itemname= driver.findElement(By.xpath("//a[contains(text(),'Impulse Duffle')]")).getText();
return itemname;
    }

    /**
     * click on alladdtocart button in wishlist
     */
    public void wishListAddtoCartButton()
    {
        WebElement addtocartWisfList= driver.findElement(By.xpath("//span[text()='Add All to Cart']/parent::button"));
        //jse.executeScript("arguments[0].click();",addtocartWisfList);
        actions.waitAndClickOnElement(addtocartWisfList);


    }

    /**
     * return error msg to test class
     * @return
     */
    public String errorMessage()
    {
        String actualmsg=errorMsg.getText();
return actualmsg;
    }

    /**
     * click on add to cart button
     * @throws InterruptedException
     */
    public void addtoCart() throws InterruptedException {
        Thread.sleep(3000);
        addtocart.click();
    }

    /**
     * click on proceed to checkout
     */

    public void proceedtoCheckoutclick()
    {
        driver.findElement(By.xpath("//button[@title='Proceed to Checkout']")).click();
    }




}
