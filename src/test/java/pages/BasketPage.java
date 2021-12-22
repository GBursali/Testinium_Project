package pages;

import utils.ITestPage;
import base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BasketPage extends BasePage implements ITestPage<BasketPage> {

    public static final String PAGEURL = BASEURL + "sepetim";

    /**Elements **/
    @FindBy(how=How.CSS,using = ".dtl > .price")
    public static WebElement labelBasketPrice;

    @FindBy(how=How.CSS,using = ".quantity[name=\"quantity\"]")
    public static WebElement labelProductCount;

    @FindBy(how=How.CSS,using = ".spinnerUp.spinnerArrow")
    public static WebElement buttonQuantityIncrease;

    @FindBy(how=How.CSS,using = ".removeProd.svgIcon_trash")
    public static WebElement buttonRemoveProduct;

    @FindBy(how=How.CSS,using = ".cartEmptyText")
    public static WebElement labelCartEmptyText;

    public BasketPage(){
        super(PAGEURL);
        PageFactory.initElements(driver,this);
        try{
            WebElement buttonKvkkPopupClose= driver.findElement(By.cssSelector("#userKvkkModal > .content > .closeBtn"));
            clickElement(buttonKvkkPopupClose);
        }
        catch (NoSuchElementException e){
            System.out.println("No kvkk. Bypassing...");
        }

    }

    /**
     * Increases the quantity of the product by 1
     */
    public BasketPage clickIncreaseQuantity(){
        System.out.println("Increasing quantity");
        clickElement(buttonQuantityIncrease);
        return this;
    }

    public BasketPage assertPrices(String price){
        String basketPrice =  labelBasketPrice.getText();
        Assertions.assertEquals(price,basketPrice);
        return this;
    }

    /**
     * Removes the product from the basket.
     */
    public BasketPage clickRemoveProduct(){
        System.out.println("Removing product");
        clickElement(buttonRemoveProduct);
        waitForLoad(labelCartEmptyText);
        return this;
    }

    /**
     * Navigates to the base URL
     *
     * @return Returning type
     */
    @Override
    public BasketPage navigate() {
        navigateToURL();
        return this;
    }

    @Override
    public BasketPage checkURL() {
        var currentURL = driver.getCurrentUrl();
        Assertions.assertEquals(PAGEURL,currentURL);
        return this;
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
