package BaseClasses;

import org.openqa.selenium.By;

public class Selectors {
    public static By LOGIN_USERNAME = By.id("email");
    public static By LOGIN_PASSWORD = By.id("password");
    public static By LOGIN_SUBMIT = By.id("loginButton");
    public static By LOGIN_INFO = By.cssSelector(".menulink.user");
    public static By SEARCH_INPUT = By.id("searchData");
    public static By SEARCH_SUBMIT = By.cssSelector(".searchbtn");


}
