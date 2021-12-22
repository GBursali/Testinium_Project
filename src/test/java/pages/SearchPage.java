package pages;

import base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;


public class SearchPage extends BasePage{
    /**Elements**/
    @FindBy(css = ".plink:not([data-isadbidding])")
    private static List<WebElement> divProducts;

    @FindBy(id = "searchData")
    private static WebElement inputSearchBox;

    @FindBy(className = "searchBtn")
    private static WebElement buttonSearchSubmit;

    @FindBy(css = ".next.navigation")
    private static WebElement buttonSecondPage;

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

    public SearchPage assertPage2Navigated(String prefix){
        String url = super.getPAGEURL() + prefix+"&pg=2";
        Assertions.assertEquals(url,driver.getCurrentUrl(),"URL yönlendirme hatası");
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
