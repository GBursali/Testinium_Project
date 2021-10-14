package components;

import base.BaseTest;
import org.openqa.selenium.By;

public class Basket extends BaseTest {

    /**Selectors **/
    public static By SELECTOR_PRICE = By.cssSelector(".dtl > .price");
    public static By MY_CART_BUTTON = By.cssSelector(".myBasket");
    public static By SELECTOR_PRODUCT_COUNT = By.cssSelector(".quantity[name=\"quantity\"]");
    public static By SELECTOR_QUANTITY_INCREASE = By.cssSelector(".spinnerUp.spinnerArrow");
    public static By SELECTOR_KVKK_POPUP_CLOSE = By.cssSelector("#userKvkkModal > .content > .closeBtn");
    public static By SELECTOR_REMOVE_PRODUCT = By.cssSelector(".removeProd.svgIcon_trash");
    public static By SELECTOR_EMPTY_TEXT = By.cssSelector(".cartEmptyText");

    /**CONSTANTS**/
    public static final String BASKETURL = BASEURL + "sepetim";

    /**
     * Checks if the current URL matches with Basket's URL
     */
    private static void assertURL(){
        checkURL(BASKETURL);
    }

    /**
     * Navigates to the Basket page. Closes the popup if opened
     */
    public static void navigate(){
        clickElement(MY_CART_BUTTON);
        assertURL();
        popupClose();
    }

    /**
     * Retrieves the total price of the basket.
     * @return Price string.
     */
    public static String getPrice(){
        return getWebElement(SELECTOR_PRICE).getText();
    }

    /**
     * Returns a product's quantity value.
     * @return quantity of the product which will be bought.
     */
    public static String getProductCount(){
        final String ATTRIBUTE_NAME = "value";
        var element = getWebElement(SELECTOR_PRODUCT_COUNT);
        return element.getAttribute(ATTRIBUTE_NAME);
    }

    /**
     * Increases the quantity of the product by 1
     */
    public static void increaseQuantity(){
        clickElement(SELECTOR_QUANTITY_INCREASE);
    }

    /**
     * Removes the product from the basket.
     */
    public static void removeProduct(){
        clickElement(SELECTOR_REMOVE_PRODUCT);
        elementLoaded(SELECTOR_EMPTY_TEXT);
    }

    /**
     * Returns if the basket has any products in it.
     * @return basket has products or not.
     */
    public static Boolean hasProduct(){
        return !elementLoaded(SELECTOR_EMPTY_TEXT);
    }

    /**
     * Closes the KVKK popup if it exists
     */
    private static void popupClose(){
        if(elementLoaded(SELECTOR_KVKK_POPUP_CLOSE))
            clickElement(SELECTOR_KVKK_POPUP_CLOSE);
    }

}
