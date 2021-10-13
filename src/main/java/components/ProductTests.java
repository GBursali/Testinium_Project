package components;

import BaseClasses.BaseTest;
import BaseClasses.Selectors;
import org.openqa.selenium.WebElement;

import java.util.Random;


public class ProductTests extends BaseTest {

    /**
     * Navigates to the random product in current page
     */
    public static WebElement getRandomProduct() {
        Random rnd = new Random();

        //Retrieve all products in current page
        var products = driver.findElements(Selectors.PRODUCTS);
        var productCount = products.toArray().length;

        //Select a random product
        return products.get(rnd.nextInt(productCount));
    }

    public static String getProductName(WebElement product){
        return product.findElement(Selectors.PRODUCT_NAME).getText();
    }

    public static void navigateProduct(WebElement product){
        product.click();
    }

    public static void addToBasket(){
        clickElement(Selectors.ADD_TO_BASKET);
    }

    public static String getPrice(){
        return getWebElement(Selectors.PRODUCT_PRICE).getText();
    }
}
