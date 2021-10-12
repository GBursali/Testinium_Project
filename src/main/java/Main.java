import BaseClasses.Constants;
import BaseClasses.Selectors;
import org.junit.Assert;
import org.junit.Test;

import static BaseClasses.Constants.*;

public class Main extends NElevenTests {
    @Test
    public void testHomePage(){
        navigate(BASEURL);
    }
    //ERROR: Login Failed with ChromeDriver
    @Test
    public void testLogin(){
        //Checking the login sequence
        navigate(LOGINURL);
        performLogin(Constants.USERNAME,Constants.PASSWORD);
        checkLogin();
    }
    @Test
    public void testSearch(){
        //Checking the search sequence
        navigate(BASEURL);
        performSearch(SEARCH_KEYWORD);
        checkURL(SEARCH_RESULTSURL);
    }
    @Test
    public void testPages(){
        navigate(SEARCH_RESULTSURL);
        performPagination2();
        checkURL(SEARCH_PAGE_2_URL);
    }
    @Test
    public void testProductBasket(){
        navigate(SEARCH_PAGE_2_URL);
        getRandomProduct();
        clickElement(Selectors.ADD_TO_BASKET);
    }
    @Test
    public void testComparePrices(){
        //Retrieve Page Price data
        navigate(SEARCH_PAGE_2_URL);
        getRandomProduct();
        var productPagePrice = getWebElement(Selectors.PRODUCT_PRICE).getText();
        clickElement(Selectors.ADD_TO_BASKET);

        //Retrieve Cart Price Data
        clickElement(Selectors.MYBASKETBUTTON);
        var basketPagePrice = getWebElement(Selectors.BASKET_PRICE).getText();
        Assert.assertEquals(basketPagePrice,productPagePrice);
    }
}
