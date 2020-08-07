package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/features/sample.feature",
                 glue="src/test/java",
                 monochrome = true,
                 strict = true)
public class joinTheTeam_testRunner {

}