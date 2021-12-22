package pages;

import entities.ITestPage;
import base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage implements ITestPage<HomePage> {
    /**CONSTANTS**/
    public static final String PAGEURL = BASEURL;

    @FindBy(how = How.CSS, using = ".menuLink.user")
    public static WebElement labelUserInfo;

    @FindBy(how = How.CSS, using = ".btnSignIn")
    public static WebElement buttonSignIn;

    public HomePage(){
        super(PAGEURL);
        PageFactory.initElements(driver,this);
    }
    public HomePage assertUserLoggedIn(){
        waitForLoad(labelUserInfo);
        Assertions.assertNotNull(labelUserInfo,"Kullanıcı bulunamadı");
        return this;
    }

    public LoginPage clickSignIn(){
        clickElement(buttonSignIn);
        return new LoginPage();
    }

    /**
     * Navigates to the base URL
     *
     * @return Returning type
     */
    @Override
    public HomePage navigate() {
        navigateToURL();
        return this;
    }
    @Override
    public HomePage checkURL() {
        var currentURL = driver.getCurrentUrl();
        Assertions.assertEquals(PAGEURL,currentURL);
        return this;
    }
}
