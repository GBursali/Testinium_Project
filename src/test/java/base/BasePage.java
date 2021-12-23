package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasketPage;
import pages.SearchPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends BaseTest{

    @FindBy(className ="myBasket")
    private static WebElement buttonMyBasket;

    private static final By buttonKvkkClose = By.cssSelector("#userKvkkModal > .content > .closeBtn");

    public String getPAGEURL() {
        return BASEURL;
    }

    public BasePage() {
        PageFactory.initElements(driver,this);
    }

    public BasketPage navigateToBasket(){
        clickElement(buttonMyBasket);
        try{
            WebElement buttonKvkkPopupClose= waitForLoad(buttonKvkkClose);
            clickElement(buttonKvkkPopupClose);
        }
        catch (TimeoutException e){
            LOG.info("No kvkk. Bypassing...");
        }
        return focusOn(BasketPage.class);
    }

    protected  <T> T focusOn(Class<T> type){
        try {
            return type.getDeclaredConstructor().newInstance();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SearchPage focusOnSearchBox(){
        return focusOn(SearchPage.class);
    }

    public WebElement waitForLoad(WebElement element) {
        return waiter.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForLoad(By selector) {
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    /*Performing actions in the website*/

    /**
     * Clicks an element
     *
     * @param element Element to be clicked
     */
    public void clickElement(WebElement element) {
        waiter.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

}