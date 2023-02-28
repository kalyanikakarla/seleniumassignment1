package PageClasses;

import Actions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    public SeleniumActions actions;
    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        actions=new SeleniumActions(driver);
        this.driver=driver;
    }
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailInputBox;
    @FindBy(xpath = "//input[@title='Password']")
    WebElement passwordInputBox;
    @FindBy(xpath = "//span[text()='Sign In']/parent::button[@class='action login primary']")
    WebElement signInButton;

    /**
     * login with mail and password
     * @param email
     * @param pasword
     */
    public void login(String email,String pasword)
    {
        actions.enterValue(emailInputBox,email);
        actions.enterValue(passwordInputBox,pasword);
        actions.clickOnElement(signInButton);
    }

}
