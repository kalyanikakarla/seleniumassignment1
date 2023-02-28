package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    WebDriverWait webDriverWait;
    public Waits(WebDriver driver){

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public WebElement waitForElementToBeClickable(WebElement element){
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
