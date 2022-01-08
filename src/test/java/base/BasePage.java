package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasketPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends TestBase {
    public static final String BASEURL = "https://www.n11.com/";
    public static WebDriver driver = TestBase.driver;
    @FindBy(className ="myBasket")
    public static WebElement buttonMyBasket;

    public static final By buttonKvkkClose = By.cssSelector("#userKvkkModal > .content > .closeBtn");

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
            LOG.info("KVKK popup found and destroyed.");
        }
        catch (TimeoutException e){
            LOG.info("No kvkk. Bypassing...");
        }
        return focusOn(BasketPage.class);
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