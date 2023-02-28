package PageClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

   public WebDriver driver;

    /**
     * Chromebrowser setup
     */
    @BeforeSuite
    public  void browserSetUp()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    /**
     * launching the application
     */
    @BeforeTest
    public void urlSetUp()
    {
        driver.get(" https://magento.softwaretestingboard.com/customer/account/");
        driver.manage().window().maximize();
    }
}
