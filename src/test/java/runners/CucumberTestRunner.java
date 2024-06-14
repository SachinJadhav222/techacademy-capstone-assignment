package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import utils.BaseClass;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "utils"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
