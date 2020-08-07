package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/features/UserStory2.feature",
                 glue = "stepdefinitions",
                 monochrome = true,
                 strict = true)
public class leadership_testRunner {


}
