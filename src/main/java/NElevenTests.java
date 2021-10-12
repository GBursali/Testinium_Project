import BaseClasses.BaseTest;
import BaseClasses.Constants;
import BaseClasses.Selectors;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.Random;

import static BaseClasses.Constants.*;

public class NElevenTests extends BaseTest {

    public void performLogin(String username, String password){
        sendTextToSelector(Selectors.LOGIN_USERNAME, username);
        clickElement(Selectors.LOGIN_PASSWORD);
        sendTextToSelector(Selectors.LOGIN_PASSWORD, password);
        getWebElement(Selectors.LOGIN_SUBMIT).submit();
        checkLogin();
    }
    public void checkLogin(){
        var element = getWebElement(Selectors.LOGIN_INFO);
        Assert.assertNotNull(element);
    }
    public void performSearch(String searchText){
        sendTextToSelector(Selectors.SEARCH_INPUT,searchText);
        clickElement(Selectors.SEARCH_SUBMIT);
    }
    public void performPagination2(){
        clickElement(Selectors.PAGE_2);
        checkURL(SEARCH_PAGE_2_URL);
    }
    public void getRandomProduct(){
        var products = driver.findElements(Selectors.PRODUCTS);
        var productCount = products.toArray().length;
        Random rnd = new Random();
        var selectedProduct = products.get(rnd.nextInt(productCount));
        selectedProduct.click();
    }
}
