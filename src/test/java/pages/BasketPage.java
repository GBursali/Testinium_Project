package pages;

import base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage{

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



    /**
     * Increases the quantity of the product by 1
     */
    public void clickIncreaseQuantity(){
        LOG.info("Increasing quantity");
        clickElement(buttonQuantityIncrease);
    }

    public BasketPage assertPrices(String price){
        String basketPrice = labelBasketPrice.getText();
        Assertions.assertEquals(price,basketPrice);
        return this;
    }

    /**
     * Removes the product from the basket.
     */
    public void clickRemoveProduct(){
        LOG.info("Removing product");
        clickElement(buttonRemoveProduct);
        waitForLoad(labelCartEmptyText);
    }

    public String getQuantity(){
        LOG.info("Product counting");
        return labelProductCount.getText();
    }
    public BasketPage assertQuantity() {
        String quantity = getQuantity();
        clickIncreaseQuantity();
        Assertions.assertEquals(quantity,getQuantity());
        return this;
    }
}
