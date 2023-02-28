package com.Grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class Lamdatest {
    public WebDriver driver;
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
                driver.get(" https://magento.softwaretestingboard.com/customer/account/");
                try {
                    driver = new RemoteWebDriver(new URL("https://kakarlakalyani123:LGLhnIXyxUg1e4hkImh8ybq3EtjK37dsHjambcCzz4gj3UXJFM@hub.lambdatest.com/wd/hub"), chromeOptions);
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
                    driver = new RemoteWebDriver(new URL("https://kakarlakalyani123:LGLhnIXyxUg1e4hkImh8ybq3EtjK37dsHjambcCzz4gj3UXJFM@hub.lambdatest.com/wd/hub"), edgeOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println(" Provide a valid Browser Name ");


        }
    }
}
