package components;

import BaseClasses.BaseTest;
import BaseClasses.Constants;
import org.openqa.selenium.By;

public class Basket extends BaseTest {

    /**Selectors **/
    public static By SELECTOR_PRICE = By.cssSelector(".dtl.total > .price");
    public static By MY_CART_BUTTON = By.cssSelector(".myBasket");
    public static By SELECTOR_PRODUCT_COUNT = By.cssSelector(".quantity[name=\"quantity\"]");
    public static By SELECTOR_QUANTITY_INCREASE = By.cssSelector(".spinnerUp.spinnerArrow");
    public static By SELECTOR_KVKK_POPUP_CLOSE = By.cssSelector("#userKvkkModal > .content > .closeBtn");
    public static By SELECTOR_REMOVE_PRODUCT = By.cssSelector(".removeProd.svgIcon_trash");
    public static By SELECTOR_EMPTY_TEXT = By.cssSelector(".cartEmptyText");

    private static void assertURL(){
        checkURL(Constants.BASKETURL);
    }

    public static void navigate(){
        clickElement(MY_CART_BUTTON);
        assertURL();
        popupClose();
    }

    public static String getPrice(){
        return getWebElement(SELECTOR_PRICE).getText();
    }

    public static String getProductCount(){
        final String ATTRIBUTE_NAME = "value";
        var element = getWebElement(SELECTOR_PRODUCT_COUNT);
        return element.getAttribute(ATTRIBUTE_NAME);
    }

    public static void increaseQuantity(){
        clickElement(SELECTOR_QUANTITY_INCREASE);
    }

    public static void removeProduct(){
        clickElement(SELECTOR_REMOVE_PRODUCT);
        elementLoaded(SELECTOR_EMPTY_TEXT);
    }

    public static Boolean hasProduct(){
        return !elementLoaded(SELECTOR_EMPTY_TEXT);
    }

    private static void popupClose(){

        if(elementLoaded(SELECTOR_KVKK_POPUP_CLOSE))
            clickElement(SELECTOR_KVKK_POPUP_CLOSE);
    }
}
