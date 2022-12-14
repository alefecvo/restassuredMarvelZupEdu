package zup.edu.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        glue = "zup.edu.stepDefinitions",
        features = "src/test/resources/features"
)

public class RunnerTest {
}
