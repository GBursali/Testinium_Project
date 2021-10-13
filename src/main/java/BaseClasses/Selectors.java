package BaseClasses;

import org.openqa.selenium.By;

/**
 * Selectors that the website is currently using
 * Needs update on fail
 */
public class Selectors {
    public static By LOGIN_USERNAME = By.id("email");
    public static By LOGIN_PASSWORD = By.id("password");
    public static By LOGIN_SUBMIT = By.id("loginButton");
    public static By LOGIN_INFO = By.cssSelector(".menuLink.user");

    public static By SEARCH_INPUT = By.id("searchData");
    public static By SEARCH_SUBMIT = By.cssSelector(".searchBtn");

    public static By PAGE_2 = By.cssSelector(".next.navigation");

    public static By PRODUCTS = By.cssSelector(".plink:not([data-isadbidding])");
    public static By PRODUCT_NAME = By.cssSelector(".productName");
    public static By PRODUCT_PRICE = By.cssSelector("ins[content]");
    public static By PRODUCT_CAMPAIGN_PRICE = By.cssSelector(".campaignDiscount");

    public static By ADD_TO_BASKET = By.cssSelector(".btnAddBasket,.addBasketUnify");
    public static By BASKET_PRICE = By.cssSelector(".dtl.total > .price");
    public static By MY_CART_BUTTON = By.cssSelector(".myBasket");

}
