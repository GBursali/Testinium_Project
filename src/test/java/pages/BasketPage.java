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

    public static final By buttonKvkkClose = By.cssSelector("#userKvkkModal > .content > .closeBtn");
    public BasketPage(){
        try{
            WebElement buttonKvkkPopupClose= driver.findElement(buttonKvkkClose);
            clickElement(buttonKvkkPopupClose);
        }
        catch (NoSuchElementException e){
            System.out.println("No kvkk. Bypassing...");
        }

    }

    /**
     * Increases the quantity of the product by 1
     */
    public void clickIncreaseQuantity(){
        System.out.println("Increasing quantity");
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
        System.out.println("Removing product");
        clickElement(buttonRemoveProduct);
        waitForLoad(labelCartEmptyText);
    }

    public String getQuantity(){
        System.out.println("Product counting");
        return labelProductCount.getText();
    }
    public BasketPage assertQuantity() {
        String quantity = getQuantity();
        clickIncreaseQuantity();
        Assertions.assertEquals(quantity,getQuantity());
        return this;
    }
}
