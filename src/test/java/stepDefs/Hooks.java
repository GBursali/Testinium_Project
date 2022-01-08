package stepDefs;

import base.TestBase;
import org.apache.log4j.xml.DOMConfigurator;
import org.json.JSONObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class Hooks extends TestBase {

    @io.cucumber.java.BeforeAll
    @org.junit.jupiter.api.BeforeAll
    public static void setupTest(){
        System.out.println("Driver up");
        Path driverFilePath = new File("src/test/resources/chromedriver.exe").toPath();

        //Driver Settings
        System.setProperty("webdriver.chrome.driver", driverFilePath.toString());
        driverOptions = new ChromeOptions();
        driverOptions.addArguments("--ignore-certificate-errors",
                "--disable-popup-blocking",
                "--start-maximized",
                "--disable-notifications");

        driver = new ChromeDriver(driverOptions);
        TestBase.waiter = new WebDriverWait(driver, Duration.ofSeconds(10));

        //test start step
        DOMConfigurator.configure("./log4jconfig.xml");
        LOG.info("-----Test flow started-------");
        driver.get(BASEURL);
    }

    public static JSONObject getProperties(){
        Path configFilePath = new File("src/test/resources/config.json").toPath();
        //reading test settings file
        try {
            String content = Files.readString(configFilePath);
            return new JSONObject(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @io.cucumber.java.AfterAll
    @org.junit.jupiter.api.AfterAll
    public static void killDriver(){
        driver.quit();
    }
}
