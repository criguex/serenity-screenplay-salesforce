package test.accountsalesforce.runner;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/CreateAccount.feature",
        glue = "test.accountsalesforce.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunCreateAccountFeature {
}
