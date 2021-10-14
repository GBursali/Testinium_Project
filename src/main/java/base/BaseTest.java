package base;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base class for Test purposes
 */
public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait waiter;
    public static final String BASEURL = "https://www.n11.com/";

    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","./driver/editedChromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors",
                "--disable-popup-blocking",
                "--disable-notifications");
        driver = new ChromeDriver(options);
        waiter = new WebDriverWait(driver,20,500);
    }

    /**
     * Navigate and maximize for url. This function includes checking that page is navigated.
     * @param url navingating Address
     */
    public static void navigate(String url){
        driver.navigate().to(url);
        driver.manage().window().maximize();
        checkURL(url);
    }

    /**
     * Gets the element from driver after it has been loaded.
     * @param selector Element's selector
     * @return Loaded element
     */
    public static WebElement getWebElement(By selector){
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    /*Performing actions in the website*/
    /**
     * Finds an element in current driver and types into it
     * @param selector Element's selector
     * @param text Text to be typed
     */
    public static void sendTextToSelector(By selector, String text){
        var element = getWebElement(selector);
        element.sendKeys(text);
    }

    /**
     * Clicks an element
     * @param selector Element's selector
     */
    public static void clickElement(By selector){
        waiter.until(ExpectedConditions.visibilityOfElementLocated(selector));
        getWebElement(selector).click();
    }

    /**
     * Checks if the current url matches with the parameter
     * @param expectedURL URL to check
     */
    public static void checkURL(String expectedURL){
        var currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,currentURL);
    }

    /**
     * Waits until the element load.
     * @param selector Selector of the element which will be loaded
     * @return whether element loaded or not (timeout)
     */
    public static Boolean elementLoaded(By selector){
        try{
            waiter.until(ExpectedConditions.visibilityOfElementLocated(selector));
            return true;
        }catch (TimeoutException e){
            return false;
        }
    }

    @After
    public void KillDriver(){
        driver.quit();
    }
}
