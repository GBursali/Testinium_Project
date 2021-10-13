import BaseClasses.BaseTest;
import BaseClasses.Constants;
import components.Basket;
import components.Login;
import components.Product;
import components.Search;
import org.junit.Assert;
import org.junit.Test;

import static BaseClasses.Constants.*;

public class Tests extends BaseTest{
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
        Login.perform(Constants.USERNAME,Constants.PASSWORD);
        Login.check();
        System.out.println("Login assertion success");
    }

    /**
     * Test if we can use the Search Box
     */
    @Test
    public void testSearch(){
        navigate(BASEURL);
        Search.perform(SEARCH_KEYWORD);
        checkURL(SEARCH_RESULTSURL);
        System.out.println("Search assertion success");
    }

    /**
     * Test if we can navigate to page 2
     */
    @Test
    public void testPages(){
        navigate(SEARCH_RESULTSURL);
        Search.navigatePage2();
        checkURL(SEARCH_PAGE_2_URL);
        System.out.println("Page assertion success");
    }

    /**
     * Test if we can add a random product on our basket
     */
    @Test
    public void testProductBasket(){
        this.fillBasket();
        System.out.println("Random product assertion success");
    }

    /**
     * Test if prices on the basket is same with the Product page
     */
    @Test
    public void testComparePrices(){
        fillBasket();
        var productPagePrice = Product.getPrice();

        /*Basket Page*/
        Basket.navigate();
        var basketPagePrice = Basket.getPrice();

        //Check
        Assert.assertEquals(basketPagePrice,productPagePrice);
        System.out.println("Price assertion success");
    }

    @Test
    public void testBasketQuantity(){
        //add product to the basket
        fillBasket();

        Basket.navigate();
        Assert.assertTrue(Basket.hasProduct());
        var oldQuantity = Basket.getProductCount();

        Basket.increaseQuantity();

        var newQuantity = Basket.getProductCount();

        //Confirmations
        Assert.assertEquals(oldQuantity,"1");
        Assert.assertEquals(newQuantity,"2");
        System.out.printf("New Quantity: %s%n",newQuantity);
    }
    @Test
    public void testBasketRemoveProduct(){
        //add product to the basket
        fillBasket();
        Basket.navigate();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Basket.removeProduct();

        Assert.assertFalse(Basket.hasProduct());
        System.out.println("Product remove from basket completed.");
    }

    private void    fillBasket(){
        navigate(SEARCH_PAGE_2_URL);

        var product = Product.getRandom();

        //Log the product name
        System.out.printf("Product name : %s%n", Product.getName(product));
        Product.navigate(product);

        Product.addToBasket();
    }
}
