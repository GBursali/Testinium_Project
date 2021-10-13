package components;

import BaseClasses.BaseTest;
import BaseClasses.Selectors;

import static BaseClasses.Constants.BASEURL;
import static BaseClasses.Constants.SEARCH_PAGE_2_URL;

public class SearchTests extends BaseTest {
    /**
     * Uses search box to search a specific keyword
     * @param query Text to be searched
     */
    public static void performSearch(String query){
        sendTextToSelector(Selectors.SEARCH_INPUT,query);
        clickElement(Selectors.SEARCH_SUBMIT);
    }

    /**
     * Navigates to the page 2 (with website buttons)
     */
    public static void performPagination2(){
        clickElement(Selectors.PAGE_2);
        checkURL(SEARCH_PAGE_2_URL);
    }


}
