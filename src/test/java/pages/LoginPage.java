package pages;

import entities.ITestPage;
import base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage implements ITestPage<LoginPage> {
    /**CONSTANTS**/
    public static final String PAGEURL = BASEURL + "giris-yap";

    @FindBy(how= How.CSS, using = "#email")
    public static WebElement inputUsername;

    @FindBy(how = How.CSS, using = "#password")
    public static WebElement inputPassword;

    @FindBy(how = How.CSS, using = "#loginButton")
    public static WebElement buttonLogin;

    public LoginPage(){
        super(PAGEURL);
        PageFactory.initElements(driver, this);
    }

    public LoginPage sendUsername(String username){

        waitForLoad(inputUsername).sendKeys(username);
        return this;
    }
    public LoginPage sendPassword(String password){
        waitForLoad(inputPassword).sendKeys(password);
        return this;
    }
    public HomePage submitLoginForm(){
        clickElement(buttonLogin);
        return new HomePage();
    }
    /**
     * Navigates to the base URL
     *
     * @return Returning type
     */
    @Override
    public LoginPage navigate() {
        navigateToURL();
        return this;
    }
    @Override
    public LoginPage checkURL() {
        var currentURL = driver.getCurrentUrl();
        Assertions.assertEquals(PAGEURL,currentURL);
        return this;
    }
}
