package stepDefs;

import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginStepDefs extends BasePage {
    public static final String PAGEURL = "https://www.n11.com/giris-yap";
    private String USERNAME;
    private String PASSWORD;

    /**Elements**/

    @FindBy(id = "email")
    private static WebElement inputUsername;

    @FindBy(id = "password")
    private static WebElement inputPassword;

    @FindBy(id = "loginButton")
    private static WebElement buttonLogin;

    @Then("Assert that we navigated to the Login Page")
    public void assertThatWeNavigatedToTheLoginPage() {
        assertUrlMatching(PAGEURL);
        LOG.info("Login URL match.");
    }

    @Given("Username data")
    public void usernameData() {
        USERNAME = testSettings.getString("username");
        LOG.info("Username found");
    }

    @And("Password data")
    public void passwordData() {
        PASSWORD = testSettings.getString("password");
        LOG.info("Password found");
    }

    @When("Write the Username to the Username field")
    public void writeTheUsernameToTheUsernameField() {
        waitForLoad(inputUsername).sendKeys(USERNAME);
        LOG.info("Username typed to the " + inputUsername.getTagName());
    }

    @And("Write the Password to the Password Field")
    public void writeThePasswordToThePasswordField() {
        waitForLoad(inputPassword).sendKeys(PASSWORD);
        LOG.info("Password typed to the " + inputPassword.getTagName());
    }

    @And("Submit the Login form")
    public void submitTheLoginForm() {
        clickElement(buttonLogin);
        LOG.info("Login form submit.");
    }

}
