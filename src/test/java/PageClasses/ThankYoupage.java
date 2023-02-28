package PageClasses;

import Actions.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ThankYoupage {
    private WebDriver driver;
    public SeleniumActions actions;
    public ThankYoupage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver=driver;
        actions=new SeleniumActions(driver);
    }
    public WebElement  ordernumber()
    {
        WebElement orderNumber=driver.findElement(By.xpath("//div[@class='checkout-success']/p/a/strong"));
        orderNumber.click();
        return orderNumber;
    }

}
