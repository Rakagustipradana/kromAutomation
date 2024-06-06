package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        tags = "@positiveNegative",
        dryRun = false,
        features = {"src/test/resources/Features/"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "pretty", "json:target/cucumber/positiveNegative.json"},
        glue = {"stepdefinitions"}
)
public class positiveNegativeRunner {
}
