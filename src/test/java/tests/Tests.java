package tests;

import base.BaseTest;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.*;
import base.BasePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.TestResultLogger;

@ExtendWith(TestResultLogger.class)
class Tests extends BaseTest {
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
                .sendUsername(USERNAME)
                .sendPassword(PASSWORD)

                .submitLoginForm()
                .assertUserLoggedIn()

                .focusOn(SearchPage.class)
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
            .clickRemoveProduct();
    }
}
