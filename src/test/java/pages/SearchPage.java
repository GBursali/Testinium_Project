package pages;

import base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.Random;


public class SearchPage extends BasePage{
    /**Elements**/
    @FindBy(how = How.CSS,using = ".plink:not([data-isadbidding])")
    public static List<WebElement> divProducts;

    @FindBy(how = How.CSS,using = "#searchData")
    public static WebElement inputSearchBox;

    @FindBy(how = How.CSS,using = ".searchBtn")
    public static WebElement buttonSearchSubmit;

    @FindBy(how = How.CSS,using = ".next.navigation")
    public static WebElement buttonSecondPage;

    public SearchPage sendQueryToTheSearchbox(String query){
        waitForLoad(inputSearchBox).sendKeys(query);
        return this;
    }

    public SearchPage clickSearchSubmit(){
        clickElement(buttonSearchSubmit);
        return this;
    }
    public SearchPage clickNavigatePage2(){
        clickElement(buttonSecondPage);
        return this;
    }

    public SearchPage assertPage2Navigated(){
        String url = super.getPAGEURL() + "&pg=2";
        Assertions.assertEquals(url,driver.getCurrentUrl());
        return this;
    }

    public ProductPage selectRandomProduct(){
        Random rnd = new Random();
        var productCount = divProducts.toArray().length;

        //Select a random product
        var selectedProduct = divProducts.get(rnd.nextInt(productCount));
        waitForLoad(selectedProduct).click();
        return new ProductPage();
    }
}
