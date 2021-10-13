package components;

import BaseClasses.BaseTest;
import org.openqa.selenium.By;


public class Search extends BaseTest {
    /**Selectors**/
    public static By SELECTOR_INPUT = By.id("searchData");
    public static By SELECTOR_SUBMIT = By.cssSelector(".searchBtn");
    public static By SELECTOR_PAGE_2 = By.cssSelector(".next.navigation");

    /**CONSTANTS**/
    public static final String SEARCH_KEYWORD = "bilgisayar";
    public static final String SEARCH_RESULTSURL = BASEURL +"arama?q="+SEARCH_KEYWORD;
    public static final String SEARCH_PAGE_2_URL = SEARCH_RESULTSURL + "&pg=2";

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
