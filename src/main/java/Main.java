import BaseClasses.Constants;

import static BaseClasses.Constants.BASEURL;
import static BaseClasses.Constants.SEARCH_KEYWORD;

public class Main extends NElevenTests {

    public static void main(String[] args){
        //also checks for the successfully navigated.
        navigate(BASEURL);

        //Checking the login sequence
        performLogin(Constants.USERNAME,Constants.PASSWORD);
        checkLogin();

        //Checking the search sequence
        performSearch(SEARCH_KEYWORD);
    }
}
