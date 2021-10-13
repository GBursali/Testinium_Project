import BaseClasses.Constants;
import BaseClasses.Selectors;
import org.junit.Assert;
import org.junit.Test;

import static BaseClasses.Constants.*;

public class Main extends NElevenTests {
    /**
     * Test if we can navigate to the homepage
     */
    @Test
    public void testHomePage(){
        navigate(BASEURL);
        System.out.println("Homepage assertion success");
    }

    /**
     * Test if we can log in (with temporary credentials)
     */
    @Test
    public void testLogin(){
        navigate(LOGINURL);
        performLogin(Constants.USERNAME,Constants.PASSWORD);
        checkLogin();
        System.out.println("Login assertion success");
    }

    /**
     * Test if we can use the Search Box
     */
    @Test
    public void testSearch(){
        navigate(BASEURL);
        performSearch(SEARCH_KEYWORD);
        checkURL(SEARCH_RESULTSURL);
        System.out.println("Search assertion success");
    }

    /**
     * Test if we can navigate to page 2
     */
    @Test
    public void testPages(){
        navigate(SEARCH_RESULTSURL);
        performPagination2();
        checkURL(SEARCH_PAGE_2_URL);
        System.out.println("Page assertion success");
    }

    /**
     * Test if we can add a random product on our basket
     */
    @Test
    public void testProductBasket(){
        //check if we can
        navigate(SEARCH_PAGE_2_URL);
        getRandomProduct();
        clickElement(Selectors.ADD_TO_BASKET);
        System.out.println("Random product assertion success");
    }

    /**
     * Test if prices on the basket is same with the Product page
     */
    @Test
    public void testComparePrices(){
        navigate(SEARCH_PAGE_2_URL);

        //Retrieve product page price data
        getRandomProduct();
        var productPagePrice = getWebElement(Selectors.PRODUCT_PRICE).getText();

        clickElement(Selectors.ADD_TO_BASKET);

        //Retrieve Cart Price Data
        clickElement(Selectors.MY_CART_BUTTON);
        var basketPagePrice = getWebElement(Selectors.BASKET_PRICE).getText();

        //Control
        Assert.assertEquals(basketPagePrice,productPagePrice);
        System.out.println("Price assertion success");
    }
}
