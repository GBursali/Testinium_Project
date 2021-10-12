import BaseClasses.BaseTest;
import BaseClasses.Selectors;
import org.junit.Assert;

import static BaseClasses.Constants.*;

public class NElevenTests extends BaseTest {
    public static void performLogin(String username, String password){
        sendTextToSelector(Selectors.LOGIN_USERNAME,username);
        sendTextToSelector(Selectors.LOGIN_PASSWORD,password);
        clickElement(Selectors.LOGIN_SUBMIT);
    }
    public static void checkLogin(){
        var element = getWebElement(Selectors.LOGIN_INFO);
        Assert.assertNotNull(element);
    }
    public static void performSearch(String searchText){
        sendTextToSelector(Selectors.SEARCH_INPUT,searchText);
        clickElement(Selectors.SEARCH_SUBMIT);
    }
}
