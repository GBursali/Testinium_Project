package BaseClasses;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static BaseClasses.Constants.BASEURL;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait waiter;

    @Before
    public void setupDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors","disable-popup-blocking","--disable-notifications");
        driver = new ChromeDriver(options);
        //Delay for waiting page load.
        waiter = new WebDriverWait(driver,2);
    }

    /**
     * Navigate and maximize for url
     * @param url navingating Address
     */
    public static void navigate(String url){
        driver.navigate().to(url);
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getCurrentUrl(),BASEURL);
    }

    /**
     * Gets the element from driver after loaded.
     * @param selector Element's selector
     * @return Loaded element
     */
    public static WebElement getWebElement(By selector){
        return waiter.until(driver1 -> driver1.findElement(selector));
    }

    //Performing actions in the website
    /**
     * Finds an element in current driver and types text
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
        getWebElement(selector).click();
    }
    @After
    public void KillDriver(){
        driver.quit();
    }
}
