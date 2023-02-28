package PageClasses;

import Actions.SeleniumActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GearAndBagsPage {
   private WebDriver driver;
   JavascriptExecutor jse;
   public SeleniumActions actions;
   public GearAndBagsPage(WebDriver driver)
   {
       PageFactory.initElements(driver,this);
       this.driver=driver;
       jse=(JavascriptExecutor)driver;

       actions=new SeleniumActions(driver);

   }
   @FindBy(xpath = "//span[text()='Gear']/ancestor::a")
    WebElement gearLink;
    @FindBy(xpath="//span[text()='Bags']/parent::a")
   WebElement bagsLink;

    /**
     * clicking on bags link
     */
   public void gearAndBag()
   {
       actions.clickOnElement(gearLink);
       jse.executeScript("arguments[0].click();",bagsLink);

   }


}
