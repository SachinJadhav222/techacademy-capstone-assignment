package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * Base class for setting up and managing WebDriver for Selenium tests.
 */
public class BaseClass {
    // Protected WebDriver instance, accessible by subclasses
    protected WebDriver driver;

    /**
     * Sets up the WebDriver using WebDriverManager and initializes ChromeDriver.
     * Maximizes the browser window.
     */
    public void setup() {
        // Setup ChromeDriver using WebDriverManager to ensure the correct version is used
        WebDriverManager.chromedriver().setup();

        // Initialize the ChromeDriver instance
        this.driver = new ChromeDriver();

        // Maximize the browser window
        this.driver.manage().window().maximize();
    }

    /**
     * Tears down the WebDriver instance by quitting the browser.
     */
    public void tearDown() {
        // If the driver is not null, quit the browser
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    /**
     * Visits a specified URL.
     *
     * @param url The URL to navigate to.
     */
    public void visitWeb(String url) {
        // Navigate to the specified URL
        this.driver.get(url);
    }

    /**
     * Gets the title of the current page.
     *
     * @return The title of the current page.
     */
    public String getTitle() {
        // Return the title of the current page
        return this.driver.getTitle();
    }

    /**
     * Clicks on a link with the specified link text.
     *
     * @param linkText The visible text of the link to click on.
     */
    public void i_click_on_link(String linkText) {
        // Find the link by its text and click on it
        driver.findElement(By.linkText(linkText)).click();
    }

    /**
     * Asserts that the text on the page matches the expected text.
     *
     * @param expectedText The expected text to be verified on the page.
     */
    public void the_text_on_the_page_should_be(String expectedText) {
        // Find the element by tag name and get its text
        String actualText = driver.findElement(By.tagName("h3")).getText();

        // Assert that the actual text matches the expected text
        Assert.assertEquals(actualText, expectedText);
    }

    /**
     * Navigates back to the home page.
     */
    public void i_navigate_back_to_the_home_page() {
        // Navigate back to the previous page
        driver.navigate().back();
    }

    /**
     * Selects an option from a dropdown by visible text.
     *
     * @param option The visible text of the option to select.
     */
    public void i_select_from_the_dropdown(String option) {
        // Find the dropdown element by its ID
        WebElement dropdown = driver.findElement(By.id("dropdown"));

        // Initialize the Select instance and select the option by visible text
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }

    /**
     * Asserts that the selected option in the dropdown matches the expected option.
     *
     * @param expectedOption The expected option to be verified.
     */
    public void should_be_selected(String expectedOption) {
        // Find the dropdown element by its ID
        WebElement dropdown = driver.findElement(By.id("dropdown"));

        // Initialize the Select instance and get the selected option
        Select select = new Select(dropdown);
        String actualOption = select.getFirstSelectedOption().getText();

        // Assert that the actual selected option matches the expected option
        Assert.assertEquals(actualOption, expectedOption);
    }

    /**
     * Asserts that a link with the specified link text is present on the page.
     *
     * @param linkText The visible text of the link to verify.
     */
    public void link_should_be_present(String linkText) {
        // Assert that the link with the specified text is displayed
        Assert.assertTrue(driver.findElement(By.linkText(linkText)).isDisplayed());
    }
}
