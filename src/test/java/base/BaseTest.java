package base;

import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

/**
 * Base class for Test purposes
 */
public abstract class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait waiter;
    public static ChromeOptions driverOptions;
    public static final String BASEURL = "https://www.n11.com/";

    @BeforeAll
    static void setupTest(){
        File f = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());
        driverOptions = new ChromeOptions();
        driverOptions.addArguments("--ignore-certificate-errors",
                "--disable-popup-blocking",
                "--disable-notifications");
    }

    @BeforeEach
    public void setupDriver(){
        driver = new ChromeDriver(driverOptions);
        waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public JSONObject getJSONRoot(){
        try {
            File configFile = new File("src/test/resources/config.json");
            String content = Files.readString(configFile.toPath());
            return new JSONObject(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @AfterEach
    void killDriver(){
        driver.quit();
    }
}
