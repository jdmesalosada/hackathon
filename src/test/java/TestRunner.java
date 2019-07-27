import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-reports/Results.json",
            "rerun:rerun/failed_scenarios.txt"},
        features = "src/test/resources/features"
)
public class TestRunner {
}

