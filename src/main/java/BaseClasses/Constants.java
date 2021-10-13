package BaseClasses;

/**
 * Constant information related to the website
 */
public class Constants {
    public static final String SEARCH_KEYWORD = "bilgisayar";

    //URL Related constants
    public static final String BASEURL = "https://www.n11.com/";
    public static final String LOGINURL = BASEURL + "giris-yap";
    public static final String SEARCH_RESULTSURL = BASEURL +"arama?q="+SEARCH_KEYWORD;
    public static final String SEARCH_PAGE_2_URL = SEARCH_RESULTSURL + "&pg=2";
    public static final String BASKETURL = BASEURL + "sepetim";

    //Login Credentials
    public static final String USERNAME = "bursaligu@gmail.com";
    public static final String PASSWORD = "tADhkRmtj9ULGUK";

}
