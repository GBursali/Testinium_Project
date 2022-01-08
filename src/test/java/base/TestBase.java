package base;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefs.Hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

/**
 * Base class for Test purposes
 * @noinspection ALL
 */
public class TestBase {
    public static WebDriver driver;
    public static WebDriverWait waiter;
    public static ChromeOptions driverOptions;
    public static JSONObject testSettings = Hooks.getProperties();
    public static final Logger LOG = Logger.getRootLogger();
    public static final String BASEURL = "https://www.n11.com/";

    public <T> T focusOn(Class<T> type){
        try {
            return type.getDeclaredConstructor().newInstance();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public WebElement waitForLoad(WebElement element) {
        return waiter.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForLoad(By selector) {
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }
    public void assertUrlMatching(String expected){
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expected,currentUrl);
    }

    public void assertPageHasElement(WebElement element)
    {
        try{
            waitForLoad(element);
        }
        catch (TimeoutException te){
            Assertions.fail("Cart is not empty");
        }
    }
}
