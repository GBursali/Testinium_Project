package components;

import BaseClasses.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class Product extends BaseTest {
    /** Selectors**/
    public static By PRODUCTS = By.cssSelector(".plink:not([data-isadbidding])");
    public static By PRODUCT_NAME = By.cssSelector("h3.productName");
    public static By PRODUCT_PRICE = By.cssSelector("ins[content]");
    public static By ADD_TO_BASKET = By.cssSelector(".btnAddBasket,.addBasketUnify");

    /**
     * Navigates to the random product in current page
     */
    public static WebElement getRandom() {
        Random rnd = new Random();

        //Retrieve all products in current page
        var products = driver.findElements(PRODUCTS);
        var productCount = products.toArray().length;

        //Select a random product
        return products.get(rnd.nextInt(productCount));
    }

    /**
     * Returns the name text of the product
     * @param product Product element to be retrieved
     * @return Name of the product
     */
    public static String getName(WebElement product){
        elementLoaded(PRODUCT_NAME);
        var element = product.findElement(PRODUCT_NAME);
        waiter.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    /**
     * Navigates through the product detail page.
     * @param product product which will be navigated to.
     */
    public static void navigate(WebElement product){
        product.click();
    }

    /**
     * Adds the product to the basket. Needs to run by Detail page.
     */
    public static void addToBasket(){
        clickElement(ADD_TO_BASKET);
    }

    /**
     * Returns price of the product in the Detail page.
     * @return Price String
     */
    public static String getPrice(){
        return getWebElement(PRODUCT_PRICE).getText();
    }
}
