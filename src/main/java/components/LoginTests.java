package components;

import BaseClasses.Selectors;
import org.junit.Assert;

import static BaseClasses.BaseTest.*;
import static BaseClasses.Constants.*;

public class LoginTests {
    /**
     * Logs in to the website with given credentials
     * @param username Username of the user
     * @param password Password of the user
     */
    public static void performLogin(String username, String password){
        navigate(LOGINURL);
        sendTextToSelector(Selectors.LOGIN_USERNAME, username);
        clickElement(Selectors.LOGIN_PASSWORD);

        sendTextToSelector(Selectors.LOGIN_PASSWORD, password);
        getWebElement(Selectors.LOGIN_SUBMIT).submit();
    }

    /**
     * Checks if the user logged in
     */
    public static void checkLogin(){
        var element = getWebElement(Selectors.LOGIN_INFO);
        Assert.assertNotNull(element);
        System.out.printf("Logged in with: %s%n",element.getText());
    }
}
