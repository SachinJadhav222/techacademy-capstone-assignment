package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BaseClass;

public class CapstoneSteps extends BaseClass {

    WebDriver driver = getDriver();

    @Given("I launch the URL {string}")
    public void i_launch_the_URL(String url) {
        driver.get(url);
    }

    @Then("the title of the page should be {string}")
    public void the_title_of_the_page_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("I click on {string} link")
    public void i_click_on_link(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    @Then("the text on the page should be {string}")
    public void the_text_on_the_page_should_be(String expectedText) {
        String actualText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @When("I navigate back to the home page")
    public void i_navigate_back_to_the_home_page() {
        driver.navigate().back();
    }

    @And("I select {string} from the dropdown")
    public void i_select_from_the_dropdown(String option) {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }

    @Then("{string} should be selected")
    public void should_be_selected(String expectedOption) {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        String actualOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption);
    }

    @Then("{string} link should be present")
    public void link_should_be_present(String linkText) {
        Assert.assertTrue(driver.findElement(By.linkText(linkText)).isDisplayed());
    }
}
