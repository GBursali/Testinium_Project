import BaseClasses.BaseTest;
import BaseClasses.Constants;
import BaseClasses.Selectors;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.Random;

import static BaseClasses.Constants.*;

public class NElevenTests extends BaseTest {
    /**
     * Logs in to the website with given credentials
     * @param username Username of the user
     * @param password Password of the user
     */
    public void performLogin(String username, String password){
        sendTextToSelector(Selectors.LOGIN_USERNAME, username);
        clickElement(Selectors.LOGIN_PASSWORD);
        sendTextToSelector(Selectors.LOGIN_PASSWORD, password);
        getWebElement(Selectors.LOGIN_SUBMIT).submit();
    }

    /**
     * Checks if the user logged in
     */
    public void checkLogin(){
        var element = getWebElement(Selectors.LOGIN_INFO);
        Assert.assertNotNull(element);
    }

    /**
     * Uses search box to search a specific keyword
     * @param query Text to be searched
     */
    public void performSearch(String query){
        sendTextToSelector(Selectors.SEARCH_INPUT,query);
        clickElement(Selectors.SEARCH_SUBMIT);
    }

    /**
     * Navigates to the page 2 (with website buttons)
     */
    public void performPagination2(){
        clickElement(Selectors.PAGE_2);
        checkURL(SEARCH_PAGE_2_URL);
    }

    /**
     * Navigates to the random product in current page
     */
    public void getRandomProduct(){
        var products = driver.findElements(Selectors.PRODUCTS);
        var productCount = products.toArray().length;
        Random rnd = new Random();
        var selectedProduct = products.get(rnd.nextInt(productCount));
        selectedProduct.click();
    }
}
