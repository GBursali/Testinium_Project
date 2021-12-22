package tests;

import pages.*;
import base.BasePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class Tests extends BasePage {
    //Login Credentials

    @ParameterizedTest
    @ValueSource(strings = {"Bilgisayar"})
    @DisplayName("Run through all sides")
    void testExplore(String queryKeyword){
        HomePage page = new HomePage();


        ProductPage productPage = page.navigate()
                .checkURL()
                .clickSignIn()
                .sendUsername(getJSONRoot().getString("username"))
                .sendPassword(getJSONRoot().getString("password"))
                .submitLoginForm()
                .assertUserLoggedIn()
                .focusOnSearchBox(queryKeyword)
                .sendQueryToTheSearchbox(queryKeyword)
                .clickSearchSubmit()
                .clickNavigatePage2()
                .assertPage2Navigated()
                .selectRandomProduct();
        String price = productPage.getPrice();

        productPage.clickAddToBasket()
            .navigate()
            .assertPrices(price)
            .assertQuantity()
            .clickRemoveProduct();
    }
}
