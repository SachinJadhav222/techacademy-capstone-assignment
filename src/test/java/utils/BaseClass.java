package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class BaseClass {
    protected WebDriver driver;

    public void setup() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    public void tearDown() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    public void visitWeb(String url) {
        this.driver.get(url);
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public void i_click_on_link(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public void the_text_on_the_page_should_be(String expectedText) {
        String actualText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    public void i_navigate_back_to_the_home_page() {
        driver.navigate().back();
    }

    public void i_select_from_the_dropdown(String option) {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }

    public void should_be_selected(String expectedOption) {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        String actualOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption);
    }

    public void link_should_be_present(String linkText) {
        Assert.assertTrue(driver.findElement(By.linkText(linkText)).isDisplayed());
    }

}
