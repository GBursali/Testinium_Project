package base;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

/**
 * Base class for Test purposes
 */
public abstract class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait waiter;
    public static ChromeOptions driverOptions;
    public static JSONObject testSettings;
    public static final Logger LOG = Logger.getRootLogger();
    public static final String BASEURL = "https://www.n11.com/";

    @BeforeAll
    static void setupTest(){
        Path driverFilePath = new File("src/test/resources/chromedriver.exe").toPath();
        Path configFilePath = new File("src/test/resources/config.json").toPath();

        //Driver Settings
        System.setProperty("webdriver.chrome.driver", driverFilePath.toString());
        driverOptions = new ChromeOptions();
        driverOptions.addArguments("--ignore-certificate-errors",
                "--disable-popup-blocking",
                "--disable-notifications");

        driver = new ChromeDriver(driverOptions);
        waiter = new WebDriverWait(driver, Duration.ofSeconds(10));

        //reading test settings file
        try {
            String content = Files.readString(configFilePath);
            testSettings =  new JSONObject(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //test start step
        DOMConfigurator.configure("./log4jconfig.xml");
        LOG.info("-----Test flow started-------");
        driver.get(BASEURL);
    }

    public <T> T focusOn(Class<T> type){
        try {
            return type.getDeclaredConstructor().newInstance();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @AfterAll
    static void killDriver(){
        driver.quit();
    }
}
