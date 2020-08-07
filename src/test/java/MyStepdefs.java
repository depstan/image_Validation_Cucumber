import cucumber.api.*;
import cucumber.api.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import pageObjectModel.*;

public class MyStepdefs {

    @Given("^load url \"([^\"]*)\"$")
    public void loadUrl(String arg0) {
        try{
            WebDriver driver= driverFactory.getDriver();
        }catch(Exception e){
            throw new PendingException();
        }

    }

    @When("^do something$")
    public void doSomething() {
        System.out.println("MEssage");
    }

    @Then("^complete the course$")
    public void completeTheCourse() {
        Assert.assertTrue(true);
    }


}
