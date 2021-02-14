package TestRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith (Cucumber.class)

@CucumberOptions(
        features = "src/test/java/features",
//        plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber.json"},
        glue = {"StepDefinition"}
)

public class AlltestRunner {
}
