package components;

import BaseClasses.BaseTest;
import BaseClasses.Constants;
import BaseClasses.Selectors;

public class BasketTests extends BaseTest {
    private static void assertURL(){
        checkURL(Constants.BASKETURL);
    }

    public static void navigateToBasket(){
        clickElement(Selectors.MY_CART_BUTTON);
        assertURL();
    }

    public static String getBasketPrice(){
        return  getWebElement(Selectors.BASKET_PRICE).getText();
    }
}
