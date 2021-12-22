package pages;

import utils.ITestPage;
import base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage extends BasePage implements ITestPage<ProductPage> {
    /* Elements */
    @FindBy(how = How.CSS,using = "ins[content]")
    public static WebElement labelProductPrice;

    @FindBy(how = How.CSS,using = ".btnAddBasket,.addBasketUnify")
    public static WebElement buttonAddToBasket;

    public ProductPage() {
        super();
    }

    /**
     * Adds the product to the basket. Needs to run by Detail page.
     */
    public BasketPage clickAddToBasket(){
        System.out.println("Adding to the basket");
        clickElement(buttonAddToBasket);
        return new BasketPage();
    }

    /**
     * Returns price of the product in the Detail page.
     * @return Price String
     */
    public String getPrice(){
        return waitForLoad(labelProductPrice).getText();
    }

    /**
     * Navigates to the base URL
     *
     * @return Returning type
     */
    @Override
    public ProductPage navigate() {
        navigateToURL();
        return this;
    }
    @Override
    public ProductPage checkURL() {
        var currentURL = driver.getCurrentUrl();
        Assertions.assertEquals(getPAGEURL(),currentURL);
        return this;
    }
}
