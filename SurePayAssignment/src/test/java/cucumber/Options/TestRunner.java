package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = ("stepDefinitions"), plugin = { "pretty",
		"json:target/jsonReports/cucumber-report.json", "html:target/html/cucumber-reports.html" }, tags = "@GetExistingUser or @CreatePost or @ValidateEmail")
public class TestRunner {
// or @CreatePost or @ValidateEmail
}
