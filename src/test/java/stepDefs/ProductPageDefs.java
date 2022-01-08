package stepDefs;

import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageDefs extends BasePage {
    /**Elements**/
    @FindBy(css = "ins[content]")
    private static WebElement labelProductPrice;

    @FindBy(css = ".btnAddBasket,.addBasketUnify")
    private static WebElement buttonAddToBasket;

    public static String productPrice;


    @And("Product's price")
    public void productSPrice() {
        productPrice =  waitForLoad(labelProductPrice).getText();
    }

    @When("Product added to the basket")
    public void productAddedToTheBasket() {
        LOG.info("Adding to the basket");
        clickElement(buttonAddToBasket);
    }

    @And("Navigate to the basket")
    public void navigateToTheBasket() {
        clickElement(buttonMyBasket);
        try{
            WebElement buttonKvkkPopupClose= waitForLoad(buttonKvkkClose);
            clickElement(buttonKvkkPopupClose);
        }
        catch (TimeoutException e){
            LOG.info("No kvkk. Bypassing...");
        }
    }
}
