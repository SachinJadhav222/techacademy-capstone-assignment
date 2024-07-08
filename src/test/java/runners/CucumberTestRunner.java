package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Test runner for Cucumber tests using TestNG.
 * Specifies Cucumber options for feature files, step definitions, and report generation.
 */
@CucumberOptions(
        features = "src/test/resources/features", // Path to the feature files
        glue = {"steps", "utils"}, // Packages containing step definitions and hooks
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // Plugins for pretty output and HTML report generation
        monochrome = true // Ensures readable console output
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    /**
     * Provides data for parallel execution of scenarios.
     * Overrides the default DataProvider method to enable parallel execution.
     *
     * @return A two-dimensional array of objects representing the scenarios to be executed.
     */
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
