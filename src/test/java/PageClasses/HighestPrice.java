package PageClasses;

import Actions.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighestPrice {
    private WebDriver driver;
    public SeleniumActions actions;
    JavascriptExecutor jse;
    public HighestPrice(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver=driver;
        jse=(JavascriptExecutor)driver;
        actions=new SeleniumActions(driver);
    }
    @FindBy(xpath="//span[text()='My Cart']/parent::a")
    WebElement addToCart;
    @FindBy(xpath = "//*[@id=\"minicart-content-wrapper\"]/div[2]/strong")
    WebElement text;

  public  String actualtext="";

    /**
     * click on addtocarticon
     */
    public void addToCart() {

        actions.clickOnElement(addToCart);
    }

    /**
     * get Text in addtocart
     * @return return text to test class
     */
    public String addtoCartText()
    {
        String actualtext = text.getText();
        //System.out.println(actualtext);
        return actualtext;
    }

    /**
     * findinding highestprice
     * @return returns highest price
     */
        public int highestPrice() {
            List<WebElement> price = new ArrayList<WebElement>();
            price = driver.findElements(By.xpath("//span[starts-with(@id,'product-price')]"));
            //  System.out.println(price);
            List<String> priceListWithdollar = new ArrayList<String>();
            for (int i = 1; i < price.size(); i++) {
                priceListWithdollar.add(price.get(i).getText());
            }
            //System.out.println(priceListWithdollar);
            List<Float> pricelist = new ArrayList<Float>();

            for (String s : priceListWithdollar) {
                String str = "";
                for (int i = 1; i < s.length(); i++) {
                    str += s.charAt(i);

                }
                float n = Float.valueOf(str);
                pricelist.add(n);
            }
            float highprice = Collections.max(pricelist);
            int highestprice = (int) highprice;
            return highestprice;
        }

    /**
     * finding highest price item name
     * @param hprice
     * @return return item name
     */
    public String highestItemName(int hprice)
        {
        String itemname=driver.findElement(By.xpath("//span[text()='$"+hprice+".00']/ancestor::div[@class='product details product-item-details']/strong/a")).getText();
        System.out.println("highest price item name is:"+ itemname);
       // driver.findElement(By.xpath("//span[text()='$74.00']/ancestor::div[@class='price-box price-final_price']/following-sibling::div/div/div[@data-role='add-to-links']/descendant::span[text()='Add to Wish List']/parent::a"));
        return  itemname;
    }

    /**
     * clicking on wishlist icon
     * @param hprice
     */
    public void wishList(int hprice)
    {
      WebElement wishListicon=  driver.findElement(By.xpath("//span[text()='$"+hprice+".00']/ancestor::div[@class='price-box price-final_price']/following-sibling::div/div/div[@data-role='add-to-links']/descendant::span[text()='Add to Wish List']/parent::a"));
        jse.executeScript("arguments[0].click();",wishListicon);

    }


    }

