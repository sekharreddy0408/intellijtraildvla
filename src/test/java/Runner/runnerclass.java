package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


//running the project from runner class

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={"pretty","html:target/cucumber"},
        features ="src/test/resource/",
        strict=true,
        monochrome= true,
        glue = {"StepDefinitions"}
)

public class runnerclass {

}
