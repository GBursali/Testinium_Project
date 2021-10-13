package components;

import BaseClasses.BaseTest;
import BaseClasses.Constants;
import BaseClasses.Selectors;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static BaseClasses.Selectors.*;

public class Basket extends BaseTest {
    private static void assertURL(){
        checkURL(Constants.BASKETURL);
    }

    public static void navigate(){
        clickElement(Selectors.MY_CART_BUTTON);
        assertURL();

        // A popup will be shown sometimes. Close if you have it.
        try{
            clickElement(BASKET_KVKK_POPUP_CLOSE);

        }catch (TimeoutException ignored){

        }
    }

    public static String getPrice(){
        return getWebElement(Selectors.BASKET_PRICE).getText();
    }

    public static String getProductCount(){
        final String ATTRIBUTE_NAME = "value";
        var element = getWebElement(Selectors.BASKET_PRODUCT_COUNT);
        return element.getAttribute(ATTRIBUTE_NAME);
    }

    public static void increaseQuantity(){
        clickElement(Selectors.BASKET_QUANTITY_INCREASE);
    }

    public static void removeProduct(){
        clickElement(BASKET_REMOVE_PRODUCT);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(BASKET_EMPTY_TEXT));
    }

    public static Boolean hasProduct(){
        try{
            waiter.until(ExpectedConditions.visibilityOfElementLocated(BASKET_EMPTY_TEXT));
            return false;
        }
        catch (TimeoutException e){
            return true;
        }
    }
}
