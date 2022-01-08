package stepDefs;

import base.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static stepDefs.ProductPageDefs.productPrice;

public class BasketPageDefs extends BasePage {
    /**Elements **/
    @FindBy(css = ".dtl > .price")
    private static WebElement labelBasketPrice;

    @FindBy(css = ".quantity[name='quantity']")
    private static WebElement labelProductCount;

    @FindBy(css = ".spinnerUp.spinnerArrow")
    private static WebElement buttonQuantityIncrease;

    @FindBy(css = ".removeProd.svgIcon_trash")
    private static WebElement buttonRemoveProduct;

    @FindBy(className = "cartEmptyText")
    private static WebElement labelCartEmptyText;

    private static Integer productQuantity;
    @Then("Assert that prices are matching")
    public void assertThatPricesAreMatching() {
        String basketPrice = labelBasketPrice.getText();
        Assertions.assertEquals(productPrice,basketPrice);
        LOG.info("Prices are matching (Saved price and Basket's price)");
    }

    @Given("Product quantity in the Basket")
    public void productQuantityInTheBasket() {
        productQuantity= getProductQuantity();
        LOG.info("Product counted as "+productQuantity);
    }

    @When("Quantity increment button is clicked")
    public void quantityIncrementButtonIsClicked() {
        LOG.info("Increasing quantity");
        clickElement(buttonQuantityIncrease);
    }

    @Then("Quantity is increased")
    public void assertNewQuantity() {
        final int expected = productQuantity + 1;
        Assertions.assertEquals(expected,getProductQuantity());
        LOG.info("Quantity increased and now it's"+expected);
    }

    @When("Clicked to the remove button in the product")
    public void clickedToTheRemoveButtonInTheProduct() {
        clickElement(buttonRemoveProduct);
        LOG.info("Clicked to the product remove button.");
    }

    @Then("Assert that basket becomes empty")
    public void assertThatBasketBecomesEmpty() {
        assertPageHasElement(labelCartEmptyText);
        LOG.info("Basket is empty");
    }

    private static Integer getProductQuantity(){
        return Integer.parseInt(labelProductCount.getAttribute("value"));
    }
}
