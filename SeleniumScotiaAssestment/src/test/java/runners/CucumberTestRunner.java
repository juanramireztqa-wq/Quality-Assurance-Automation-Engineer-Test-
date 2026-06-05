package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * This class is the test runner for Cucumber tests. It uses JUnit to run the tests and specifies the location of feature files and step definitions.
 * The @CucumberOptions annotation is used to configure the test execution, including the location of feature files, step definitions, and plugins for reporting.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature_files",
        glue = {"step_definitions"},
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","pretty"
        }
)
public class CucumberTestRunner {
}
