package stepDefs;

import base.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeStepDefs extends BasePage {

    /**Elements**/
    @FindBy(css = ".menuLink.user")
    private static WebElement labelUserInfo;

    @FindBy(className = "btnSignIn")
    private static WebElement buttonSignIn;

    @When("Navigated to the website")
    public void navigatedToTheWebsite() {
        driver.navigate().to(BASEURL);
        LOG.info("Website navigated");
    }

    @Then("Assert that URL is matching")
    public void assertThatURLIsMatching() {
        assertUrlMatching(BASEURL);
        LOG.info("Url is stable. No redirections detected.");
    }

    @When("Clicked to the Sign In button")
    public void clickedToTheSignInButton() {
        clickElement(buttonSignIn);
        LOG.info("'Sign in' button clicked.");
    }

    @Then("Assert that we successfully logged in.")
    public void assertThatWeSuccessfullyLoggedIn() {
        waitForLoad(labelUserInfo);
        Assertions.assertNotNull(labelUserInfo,"Login failed.");
        LOG.info("Login successful");
    }
}
