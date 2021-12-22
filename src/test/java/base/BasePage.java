package base;

import org.json.JSONObject;
import org.openqa.selenium.support.PageFactory;
import pages.SearchPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BasePage extends BaseTest{


    public String getPAGEURL() {
        return PAGEURL;
    }

    private final String PAGEURL;

    public BasePage() {
        PAGEURL = BASEURL;
        PageFactory.initElements(driver,this);
    }

    public BasePage(String url) {
        PAGEURL = url;
        PageFactory.initElements(driver,this);
    }

    public SearchPage focusOnSearchBox(String keyword){
        return new SearchPage(keyword);
    }

    public void navigateToURL(){
        driver.navigate().to(PAGEURL);
        driver.manage().window().maximize();
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