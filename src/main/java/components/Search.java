package components;

import BaseClasses.BaseTest;
import org.openqa.selenium.By;

import static BaseClasses.Constants.SEARCH_PAGE_2_URL;

public class Search extends BaseTest {
    /**Selectors**/
    public static By SELECTOR_INPUT = By.id("searchData");
    public static By SELECTOR_SUBMIT = By.cssSelector(".searchBtn");
    public static By SELECTOR_PAGE_2 = By.cssSelector(".next.navigation");

    /**
     * Uses search box to search a specific keyword
     * @param query Text to be searched
     */
    public static void perform(String query){
        sendTextToSelector(SELECTOR_INPUT,query);
        clickElement(SELECTOR_SUBMIT);
    }

    /**
     * Navigates to the page 2 (with website buttons)
     */
    public static void navigatePage2(){
        clickElement(SELECTOR_PAGE_2);
        checkURL(SEARCH_PAGE_2_URL);
    }


}
