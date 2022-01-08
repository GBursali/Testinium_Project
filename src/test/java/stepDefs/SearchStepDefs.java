package stepDefs;

import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class SearchStepDefs extends BasePage {
    /**Elements**/
    @FindBy(css = ".plink:not([data-isadbidding])")
    private static List<WebElement> divProducts;

    @FindBy(id = "searchData")
    private static WebElement inputSearchBox;

    @FindBy(className = "searchBtn")
    private static WebElement buttonSearchSubmit;

    @FindBy(css = ".next.navigation")
    private static WebElement buttonSecondPage;

    public static String queryKeyword;

    @Given("Query keyword {string} to search")
    public void queryKeywordBilgisayarToBeSearched(String keyword) {
        queryKeyword = keyword;
        LOG.info("Keyword received-->"+keyword);
    }

    @When("Write the keyword to the field")
    public void writeTheKeywordToTheField() {
        waitForLoad(inputSearchBox).sendKeys(queryKeyword);
        LOG.info("Search Keyword typed to the " + inputSearchBox.getTagName());
    }

    @When("Submit the search button")
    public void submitTheSearchButton() {
        clickElement(buttonSearchSubmit);
        LOG.info("Search form submit.");
    }

    @And("Navigate to the next page")
    public void navigateToThePage() {
        clickElement(buttonSecondPage);
        LOG.info("Navigated to the second page with: " + buttonSecondPage.getTagName());
    }

    @Then("Assert that page is navigated")
    public void assertThatPageIsNavigated() {
        String url = String.format("%sarama?q=%s&pg=2",BASEURL,queryKeyword);
        assertUrlMatching(url);
        LOG.info("Page 2 successfully navigated.");
    }

    @Given("A Random product")
    public void aRandomProduct() {
        Random rnd = new Random();
        var productCount = divProducts.toArray().length;

        //Select a random product
        var selectedProduct = divProducts.get(rnd.nextInt(productCount));
        waitForLoad(selectedProduct).click();
        LOG.info("Random product selected.");
    }


}
