package com.Grid;

import PageClasses.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

public class MultiBrowser {
    public WebDriver driver;
    public LoginPage loginPage;
    public GearAndBagsPage gearAndBagsPage;
    public HighestPrice highestPrice;
    public WishListPage wishListPage;
    public ShippingAdressPage shippingAdressPage;
    public PayMentPage payMentPage;
    public ThankYoupage thankYoupage;

    public DesiredCapabilities desiredCapabilities;

    @Parameters({"browser"})
    @BeforeTest
    public void setUpBroser(String browser) {
        switch (browser) {
            case "chrome":
                desiredCapabilities = new DesiredCapabilities();
                ChromeOptions chromeOptions = new ChromeOptions();
                desiredCapabilities.setCapability("browserName", "chrome");
                chromeOptions.merge(desiredCapabilities);
                driver = new ChromeDriver();
                driver.get("https://magento.softwaretestingboard.com/customer/account/");
                try {
                    driver = new RemoteWebDriver(new URL(" http://172.18.2.222:4444/wd/hub"), chromeOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;


            case "edge":
                desiredCapabilities = new DesiredCapabilities();
                EdgeOptions edgeOptions = new EdgeOptions();
                desiredCapabilities.setCapability("browserName", "MicrosoftEdge");
                edgeOptions.merge(desiredCapabilities);
                driver = new EdgeDriver();
                driver.get(" https://magento.softwaretestingboard.com/customer/account/");
                try {
                    driver = new RemoteWebDriver(new URL("http://172.18.2.222:4444/wd/hub"), edgeOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println(" Provide a valid Browser Name ");


        }

    }
    @BeforeClass
    public void driverinitialize()
    {
        loginPage=new LoginPage(driver);
        gearAndBagsPage=new GearAndBagsPage(driver);
        highestPrice=new HighestPrice(driver);
                wishListPage=new WishListPage(driver);
       shippingAdressPage=new ShippingAdressPage(driver);
               payMentPage=new PayMentPage(driver);
        thankYoupage=new ThankYoupage(driver);
    }
    @Test
    public void login() throws InterruptedException, FileNotFoundException {
        loginPage.login("kakarlakalyani123@gmail.com","Kalyani@123");
gearAndBagsPage.gearAndBag();
highestPrice.addToCart();
highestPrice.highestPrice();
highestPrice.highestItemName(74);
highestPrice.wishList(74);
wishListPage.verifyingWishListPage();
wishListPage.wishListAddtoCartButton();
wishListPage.proceedtoCheckoutclick();
shippingAdressPage.shippingAdressdata();
shippingAdressPage.readingFileFromJson();
payMentPage.payment();
payMentPage.returnCurrentdate();
thankYoupage.ordernumber();

    }

}
