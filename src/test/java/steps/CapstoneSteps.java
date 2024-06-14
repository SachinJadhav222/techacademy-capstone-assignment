package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.BaseClass;


public class CapstoneSteps {

    private BaseClass baseClass = new BaseClass();

    @Before
    public void setup() {
        baseClass.setup();
    }

    @After
    public void teardown() {
        baseClass.tearDown();
    }

    @Given("I launch the URL {string}")
    public void i_launch_the_URL(String url) {
        baseClass.visitWeb(url);
    }

    @Then("the title of the page should be {string}")
    public void the_title_of_the_page_should_be(String expectedTitle) {
        String actualTitle = baseClass.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("I click on {string} link")
    public void i_click_on_link(String linkText) {
        baseClass.i_click_on_link(linkText);
    }

    @Then("the text on the page should be {string}")
    public void the_text_on_the_page_should_be(String expectedText) {
        baseClass.the_text_on_the_page_should_be(expectedText);
    }

    @When("I navigate back to the home page")
    public void i_navigate_back_to_the_home_page() {
        baseClass.i_navigate_back_to_the_home_page();
    }

    @And("I select {string} from the dropdown")
    public void i_select_from_the_dropdown(String option) {
        baseClass.i_select_from_the_dropdown(option);
    }

    @Then("{string} should be selected")
    public void should_be_selected(String expectedOption) {
        baseClass.should_be_selected(expectedOption);
    }

    @Then("{string} link should be present")
    public void link_should_be_present(String linkText) {
        baseClass.link_should_be_present(linkText);
    }
}
