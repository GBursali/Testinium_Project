package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage{
    /**CONSTANTS**/

    @FindBy(how= How.CSS, using = "#email")
    public static WebElement inputUsername;

    @FindBy(how = How.CSS, using = "#password")
    public static WebElement inputPassword;

    @FindBy(how = How.CSS, using = "#loginButton")
    public static WebElement buttonLogin;

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
