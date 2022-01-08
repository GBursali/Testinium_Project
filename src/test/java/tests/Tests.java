package tests;

import org.junit.jupiter.api.extension.ExtendWith;
import pages.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stepDefs.Hooks;
import utils.TestResultLogger;

@ExtendWith(TestResultLogger.class)
class Tests extends Hooks {
    //Login Credentials
    final String USERNAME = testSettings.getString("username");
    final String PASSWORD = testSettings.getString("password");

    @ParameterizedTest
    @ValueSource(strings = {"Bilgisayar"})
    @DisplayName("Run through all features")
    void testExplore(String queryKeyword){
        LOG.info("--Smoke test begins--");
        HomePage page = new HomePage();
        ProductPage productPage = page
                .assertUrl()
                .clickSignIn()
                //Navigated to Login page
                .sendUsername(USERNAME)
                .sendPassword(PASSWORD)

                .submitLoginForm()
                //Navigated to HomePage on successful login
                .assertUserLoggedIn()

                .focusOn(SearchPage.class)
                //Accessible to every page. Focused on Search box.
                //And/or Search Results
                .sendQueryToTheSearchbox(queryKeyword)
                .clickSearchSubmit()
                .clickNavigatePage2()
                .assertPage2Navigated("arama?q="+queryKeyword)
                .selectRandomProduct();

        String price = productPage.getPrice();

        productPage.clickAddToBasket()
            .navigateToBasket()
            .assertPrices(price)
            .assertQuantity()
            .clickRemoveProduct()
        .assertBasketEmpty()
        ;
    }
}
