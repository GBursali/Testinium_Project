package pages;

import base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    /**Elements**/
    @FindBy(css = ".menuLink.user")
    private static WebElement labelUserInfo;

    @FindBy(className = "btnSignIn")
    private static WebElement buttonSignIn;

    public HomePage assertUserLoggedIn(){
        waitForLoad(labelUserInfo);
        Assertions.assertNotNull(labelUserInfo,"Kullanıcı bulunamadı");
        return this;
    }

    public HomePage assertUrl(){
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(super.getPAGEURL(),currentUrl);
        return this;
    }

    public LoginPage clickSignIn(){
        clickElement(buttonSignIn);
        return new LoginPage();
    }
}
