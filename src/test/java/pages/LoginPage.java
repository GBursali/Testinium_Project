package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    /**Elements**/

    @FindBy(id = "email")
    private static WebElement inputUsername;

    @FindBy(id = "password")
    private static WebElement inputPassword;

    @FindBy(id = "loginButton")
    private static WebElement buttonLogin;

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
}
