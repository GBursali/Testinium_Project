package pages;

import base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage{
    /**CONSTANTS**/
    @FindBy(how = How.CSS, using = ".menuLink.user")
    public static WebElement labelUserInfo;

    @FindBy(how = How.CSS, using = ".btnSignIn")
    public static WebElement buttonSignIn;

    public HomePage assertUserLoggedIn(){
        waitForLoad(labelUserInfo);
        Assertions.assertNotNull(labelUserInfo,"Kullanıcı bulunamadı");
        return this;
    }

    public LoginPage clickSignIn(){
        clickElement(buttonSignIn);
        return new LoginPage();
    }
}
