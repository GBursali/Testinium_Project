import base.BaseTest;
import components.Basket;
import components.Login;
import components.Product;
import components.Search;
import org.junit.Assert;
import org.junit.Test;


public class Tests extends BaseTest{
    //Login Credentials
    public static final String USERNAME = "xxx";
    public static final String PASSWORD = "xxx";

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
        Login.perform(USERNAME,PASSWORD);
        Login.check();
        System.out.println("Login assertion success");
    }

    /**
     * Test if we can use the Search Box
     */
    @Test
    public void testSearch(){
        navigate(BASEURL);
        Search.perform(Search.SEARCH_KEYWORD);
        checkURL(Search.SEARCH_RESULTSURL);
        System.out.println("Search assertion success");
    }

    /**
     * Test if we can navigate to page 2
     */
    @Test
    public void testPages(){
        navigate(Search.SEARCH_RESULTSURL);
        Search.navigatePage2();
        checkURL(Search.SEARCH_PAGE_2_URL);
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

    /**
     * Test if we can increase the quantity of a random product
     */
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

    /**
     * Test if we can remove the product from basket.
     */
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

    /**
     * Adds a random product from page_2 to the basket.
     */
    private void fillBasket(){
        navigate(Search.SEARCH_PAGE_2_URL);

        var product = Product.getRandom();

        //Log the product name
        Product.navigate(product);
        System.out.printf("Product name : %s%n", Product.getName(product));

        Product.addToBasket();
    }
}
