package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/feature",
        glue = {"automationexercise.stepdef"},
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},tags="@DownloadInvoiceAfterPurchace",
        monochrome = true,
        publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}