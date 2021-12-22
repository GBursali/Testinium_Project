package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    /** Elements **/
    @FindBy(css = "ins[content]")
    private static WebElement labelProductPrice;

    @FindBy(css = ".btnAddBasket,.addBasketUnify")
    private static WebElement buttonAddToBasket;

    /**
     * Adds the product to the basket. Needs to run by Detail page.
     */
    public BasketPage clickAddToBasket(){
        LOG.info("Adding to the basket");
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
}
