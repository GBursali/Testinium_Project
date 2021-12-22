package tests;

import pages.*;
import base.BasePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class Tests extends BasePage {
    //Login Credentials

    @ParameterizedTest
    @ValueSource(strings = {"Bilgisayar"})
    @DisplayName("Run through all sides")
    void testExplore(String queryKeyword){
        HomePage page = new HomePage();


        ProductPage productPage = page.navigate()
                .checkURL()
                .clickSignIn()
                .sendUsername(getJSONRoot().getString("username"))
                .sendPassword(getJSONRoot().getString("password"))
                .submitLoginForm()
                .assertUserLoggedIn()
                .focusOnSearchBox(queryKeyword)
                .sendQueryToTheSearchbox(queryKeyword)
                .clickSearchSubmit()
                .clickNavigatePage2()
                .assertPage2Navigated()
                .selectRandomProduct();
        String price = productPage.getPrice();

        //add product to basket
        productPage.clickAddToBasket()
            .navigate()
            .assertPrices(price)
            .assertQuantity()
            .clickRemoveProduct();
    }

    /*
    @Test
    @DisplayName("Navigating the homepage")
    void testHomePage(){
        HomePage page = new HomePage();
        page.navigate();
        Assertions.assertTrue(page.checkURL());
        System.out.println("Homepage assertion success");
    }

    @Test
    @DisplayName("Logging in with true credentials")
    void testLoginWithRealCredentials(){
        Login loginPage = new Login();
        loginPage.sendUsername(USERNAME)
                .sendPassword(PASSWORD)
                .submitLoginForm()

                .assertUserLoggedIn();

        System.out.println("Login assertion success");
    }

    /**
     * Test if we can use the Search Box

    @ParameterizedTest
    @ValueSource(strings = {"Bilgisayar"})
    @DisplayName("Searches Through the keyword")
    void testSearch(String keyword){
        final String URLSEARCH =BASEURL + "arama?q=" + keyword;

        Search page = new Search();
        //First Search
        page.sendQueryToTheSearchbox(keyword)
                .clickSearchSubmit();
        Assertions.assertEquals(URLSEARCH,driver.getCurrentUrl());

        System.out.println("Search assertion success");
    }

    /**
     * Test if we can navigate to Page 2

    @ParameterizedTest
    @ValueSource(strings = {"Bilgisayar"})
    @DisplayName("Navigates to Search page 2")
    void testPages(String keyword){
        Search page = new Search();
        final String URLSEARCHPAGE2 = String.format(BASEURL + "arama?q=%s&pg=2",keyword);

        //Precondition
        page.sendQueryToTheSearchbox(keyword)
                .clickSearchSubmit();
        page.navigatePage2();
        Assertions.assertEquals(URLSEARCHPAGE2,driver.getCurrentUrl());

        System.out.println("Page assertion success");
    }


    /**
     * Test if we can add a random product on our basket

    @ParameterizedTest
    @ValueSource(strings = {"Bilgisayar"})
    @DisplayName("Add a random product to the basket")
    void testProductBasket(String keyword){
        //Precondition/ Given
        Search prePage = new Search();

        //when
        prePage.sendQueryToTheSearchbox(keyword)
                .clickSearchSubmit();
        prePage.addRandomProductToBasket();

        //Then
        Basket basketPage = new Basket();
        basketPage.navigate();
        Assertions.assertTrue(basketPage.hasProduct());
    }

    /**
     * Test if prices on the basket is same with the Product page

    @ParameterizedTest
    @ValueSource(strings = {"Bilgisayar"})
    @DisplayName("Compare Basket and product prices")
    void testComparePrices(String keyword){
        //Precondition
        Product page = new Product();
        page.addProductToBasket();
        fillBasket();
        var productPagePrice = Product.getPrice();

        Basket Page
        Basket.navigate();
        var basketPagePrice = Basket.getPrice();

        Check
        Assertions.assertEquals(basketPagePrice,productPagePrice);
        System.out.println("Price assertion success");
    }

    /*
     * Test if we can increase the quantity of a random product

    @Test
    void testBasketQuantity(){
        //add product to the basket
        fillBasket();

        Basket.navigate();
        Assertions.assertTrue(Basket.hasProduct());
        var oldQuantity = Basket.getProductCount();

        Basket.clickIncreaseQuantity();

        var newQuantity = Basket.getProductCount();

        //Confirmations
        Assertions.assertEquals("1", oldQuantity);
        Assertions.assertEquals("2", newQuantity);
        System.out.printf("New Quantity: %s%n",newQuantity);
    }

    /**
     * Test if we can remove the product from basket.

    @Test
    void testBasketRemoveProduct(){
        //add product to the basket
        fillBasket();
        Basket.navigate();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Basket.removeProduct();

        Assertions.assertFalse(Basket.hasProduct());
        System.out.println("Product remove from basket completed.");
    }

    /**
     * Adds a random product from page_2 to the basket.

    private void fillBasket(){
        navigate(Search.SEARCH_PAGE_2_URL);

        var product = Product.getRandomProduct();

        //Log the product name
        Product.navigateToProduct(product);
        System.out.printf("Product name : %s%n", Product.getName(product));

        Product.addToBasket();
    }

     */
}
