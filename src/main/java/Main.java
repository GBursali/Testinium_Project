import BaseClasses.BaseTest;
import BaseClasses.Constants;
import org.junit.Assert;
import org.junit.Test;

import static BaseClasses.Constants.*;
import static components.BasketTests.*;
import static components.LoginTests.*;
import static components.ProductTests.*;
import static components.SearchTests.*;

public class Main extends BaseTest{
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
        navigate(SEARCH_PAGE_2_URL);

        var product = getRandomProduct();
        //Log the product name
        System.out.printf("Product name : %s%n",getProductName(product));
        navigateProduct(product);

        System.out.println("Random product assertion success");
    }

    /**
     * Test if prices on the basket is same with the Product page
     */
    @Test
    public void testComparePrices(){
        navigate(SEARCH_PAGE_2_URL);
        /*Product Page*/

        //Get random product and open details page
        var product = getRandomProduct();
        navigateProduct(product);

        //Get price and add to basket
        var productPagePrice = getPrice();
        addToBasket();

        /*Basket Page*/
        navigateToBasket();
        var basketPagePrice = getBasketPrice();

        //Check
        Assert.assertEquals(basketPagePrice,productPagePrice);
        System.out.println("Price assertion success");
    }
}
