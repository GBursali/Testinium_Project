package base;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasketPage;
import pages.SearchPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BasePage extends BaseTest{

    @FindBy(className ="myBasket")
    private static WebElement buttonMyBasket;

    public String getPAGEURL() {
        return PAGEURL;
    }

    private final String PAGEURL;

    public BasePage() {
        PAGEURL = BASEURL;
        PageFactory.initElements(driver,this);
    }

    public BasketPage navigateToBasket(){
        clickElement(buttonMyBasket);
        return new BasketPage();
    }

    public SearchPage focusOnSearchBox(){
        return new SearchPage();
    }


    public WebElement waitForLoad(WebElement element) {
        return waiter.until(ExpectedConditions.visibilityOf(element));
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