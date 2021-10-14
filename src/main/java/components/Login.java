package components;

import org.junit.Assert;
import org.openqa.selenium.By;

import static base.BaseTest.*;

public class Login {
    /** Selectors **/
    public static By SELECTOR_USERNAME = By.id("email");
    public static By SELECTOR_PASSWORD = By.id("password");
    public static By SELECTOR_SUBMIT = By.id("loginButton");
    public static By SELECTOR_INFO = By.cssSelector(".menuLink.user");

    /**CONSTANTS**/
    public static final String LOGINURL = BASEURL + "giris-yap";


    /**
     * Logs in to the website with given credentials
     * @param username Username of the user
     * @param password Password of the user
     */
    public static void perform(String username, String password){
        navigate(LOGINURL);
        sendTextToSelector(SELECTOR_USERNAME, username);
        clickElement(SELECTOR_PASSWORD);

        sendTextToSelector(SELECTOR_PASSWORD, password);
        getWebElement(SELECTOR_SUBMIT).submit();
    }

    /**
     * Checks if the user logged in
     */
    public static void check(){
        var element = getWebElement(SELECTOR_INFO);
        Assert.assertNotNull(element);
        System.out.printf("Logged in with: %s%n",element.getText());
    }
}
