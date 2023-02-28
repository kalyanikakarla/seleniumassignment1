package PageClasses;

import Actions.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayMentPage {
    public WebDriver driver;
    public SeleniumActions actions;
    public PayMentPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver=driver;
        actions=new SeleniumActions(driver);
    }
    @FindBy(xpath = "//span[text()='Place Order']/parent::button")
    WebElement placeOrderButton;

    /**
     * click on placeorderButton
     *
     * @return
     */
    public void payment()
    {
        actions.clickOnElement(placeOrderButton);

    }

    /**
     * return current date to testclass
     *
     * @return
     */
    public String returnCurrentdate()
    {
        String date=driver.findElement(By.xpath("//div[@class='order-date']/span[text()='February 28, 2023']")).getText();
        return date;
    }


}
