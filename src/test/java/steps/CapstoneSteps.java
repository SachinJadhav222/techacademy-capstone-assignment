package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.BaseClass;

/**
 * Step definitions for Cucumber tests in the Capstone project.
 * Utilizes methods from BaseClass for WebDriver interactions.
 */
public class CapstoneSteps {

    // Instance of BaseClass to manage WebDriver setup and operations
    private BaseClass baseClass = new BaseClass();

    /**
     * Setup method to initialize WebDriver before each test.
     * Executed before each Cucumber scenario.
     */
    @Before
    public void setup() {
        baseClass.setup();
    }

    /**
     * Teardown method to quit WebDriver after each test.
     * Executed after each Cucumber scenario.
     */
    @After
    public void teardown() {
        baseClass.tearDown();
    }

    /**
     * Step definition to launch the specified URL.
     *
     * @param url The URL to navigate to.
     */
    @Given("I launch the URL {string}")
    public void i_launch_the_URL(String url) {
        baseClass.visitWeb(url);
    }

    /**
     * Step definition to verify the title of the current page.
     *
     * @param expectedTitle The expected title of the page.
     */
    @Then("the title of the page should be {string}")
    public void the_title_of_the_page_should_be(String expectedTitle) {
        String actualTitle = baseClass.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    /**
     * Step definition to click on a link with the specified text.
     *
     * @param linkText The visible text of the link to click on.
     */
    @When("I click on {string} link")
    public void i_click_on_link(String linkText) {
        baseClass.i_click_on_link(linkText);
    }

    /**
     * Step definition to verify the text on the current page.
     *
     * @param expectedText The expected text to be verified on the page.
     */
    @Then("the text on the page should be {string}")
    public void the_text_on_the_page_should_be(String expectedText) {
        baseClass.the_text_on_the_page_should_be(expectedText);
    }

    /**
     * Step definition to navigate back to the home page.
     */
    @When("I navigate back to the home page")
    public void i_navigate_back_to_the_home_page() {
        baseClass.i_navigate_back_to_the_home_page();
    }

    /**
     * Step definition to select an option from a dropdown by visible text.
     *
     * @param option The visible text of the option to select.
     */
    @And("I select {string} from the dropdown")
    public void i_select_from_the_dropdown(String option) {
        baseClass.i_select_from_the_dropdown(option);
    }

    /**
     * Step definition to verify the selected option in the dropdown.
     *
     * @param expectedOption The expected option to be selected.
     */
    @Then("{string} should be selected")
    public void should_be_selected(String expectedOption) {
        baseClass.should_be_selected(expectedOption);
    }

    /**
     * Step definition to verify that a link with the specified text is present on the page.
     *
     * @param linkText The visible text of the link to verify.
     */
    @Then("{string} link should be present")
    public void link_should_be_present(String linkText) {
        baseClass.link_should_be_present(linkText);
    }
}
