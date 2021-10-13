package components;

import BaseClasses.BaseTest;
import BaseClasses.Selectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class Product extends BaseTest {

    /**
     * Navigates to the random product in current page
     */
    public static WebElement getRandom() {
        Random rnd = new Random();

        //Retrieve all products in current page
        var products = driver.findElements(Selectors.PRODUCTS);
        var productCount = products.toArray().length;

        //Select a random product
        return products.get(rnd.nextInt(productCount));
    }

    public static String getName(WebElement product){
        var element = product.findElement(Selectors.PRODUCT_NAME);
        waiter.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public static void navigate(WebElement product){
        product.click();
    }

    public static void addToBasket(){
        clickElement(Selectors.ADD_TO_BASKET);
    }

    public static String getPrice(){
        return getWebElement(Selectors.PRODUCT_PRICE).getText();
    }
}
