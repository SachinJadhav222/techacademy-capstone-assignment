package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver-1");
        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        // Initialize the Chrome WebDriver
        WebDriver driver = new ChromeDriver(options);

        // Example usage
        driver.get("https://www.example.com");

        // Perform your actions

        // Close the browser
        driver.quit();
    }
}
