package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = {"src/test/resources"},
			snippets = SnippetType.CAMELCASE,
			plugin = {
						"pretty", 
						"html:target/cucumber-html-report", 
						"json:target/cucumber-json-report/cucumber.json"
					},
			glue = {""},
			tags = {"@ECCM-46-CT03"}
		)

public class RunnerTest {

}
