package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports",
                "json:target/cukesreport.json"},// this is for reports under target folder
        features = "src/test/resources/features",
        glue = "step_definitions",
        tags = "",
        dryRun = false
)

public class CukesRunner {
}
