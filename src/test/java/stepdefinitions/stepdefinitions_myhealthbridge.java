package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.*;
import pageObjectModel.*;

import java.io.*;


public class stepdefinitions_myhealthbridge {

    public static WebDriver driver;
    public static int minSeconds=2000, maxSeconds=4000;
    public static leadershipPage leadershippage;
    public static  joinTheTeamPage jointheteampage;
    public static myHealthBridge myhealthbridge;
    @Given("^user navigated to the myhealthbridge url \"([^\"]*)\"$")
    public void user_navigated_to_the_myhealthbridge_url(String appUrl) throws InterruptedException {
        driver= driverFactory.getDriver();
        leadershippage=new leadershipPage(driver);
        jointheteampage=new joinTheTeamPage(driver);
       myhealthbridge=new myHealthBridge(driver);
        driver.get(appUrl);
        Thread.sleep(minSeconds);
        if(driver.getTitle().equalsIgnoreCase("My HealthBridge | Home")){
            System.out.println("Home Page Loaded Successfully !!!");
        }else{
            Assert.fail("Page not Loaded.. Failing the scenario!!");
        }
    }

    @Given("^user check the \"([^\"]*)\" hyper link$")
    public void user_check_the_hyper_link(String textLink) {
        if(textLink.contains("Leadership")) {
            leadershippage.checkleadershipMenu();
        }else if(textLink.contains("Join The Team")){
            jointheteampage.checkJoinTheTeamMenu();
        }else{
            System.out.println("Link not found with the given text");
            Assert.fail();
        }

    }

    @When("^user clicks on the \"([^\"]*)\"$")
    public void user_clicks_on_the(String hyperLink) throws InterruptedException {
        if(hyperLink.contains("Leadership")) {
            leadershippage.clickleadershipMenu();
            Thread.sleep(minSeconds);
        }else if(hyperLink.contains("Join The Team")){
            jointheteampage.clickjointheTeamMenu();
            Thread.sleep(minSeconds);
        }else{
            System.out.println("Link not found with the given text");
            Assert.fail();
        }
    }

    @Then("^user will be navigate to the \"([^\"]*)\" page$")
    public void user_will_be_navigate_to_the_page(String pageName) {
        if(pageName.equalsIgnoreCase("Leadership")){
            if(driver.getTitle().contains("My HealthBridge | Meet the Team")){
                System.out.println("User is in Leadership page.");
                Assert.assertTrue(true);
            }else{
                System.out.println("User is in "+driver.getTitle()+" page");
                Assert.fail();
            }

        } else if(pageName.equalsIgnoreCase("Join The Team")){
            if(driver.getTitle().contains("My HealthBridge | Join The Team")){
                System.out.println("User is in Join the Team page.");
                Assert.assertTrue(true);
            }else{
                System.out.println("User is in "+driver.getTitle()+" page.");
                Assert.fail();
            }
        } else {
            System.out.println("Invalid page name");
            Assert.fail();
        }

    }


    @When("^user enter \"([^\"]*)\" in the keyword field$")
    public void user_enter_in_the_keyword_field(String keyword) {
        jointheteampage.enterKeyWord(keyword);
    }

    @When("^user select the category as \"([^\"]*)\"$")
    public void user_select_the_category_as(String categoryValue) {
        jointheteampage.enterCategory(categoryValue);
    }

    @When("^user select the jobtype as \"([^\"]*)\"$")
    public void user_select_the_jobtype_as(String jobText) {
        jointheteampage.enterJobType(jobText);
    }

    @When("^user select the location as \"([^\"]*)\"$")
    public void user_select_the_location_as(String locate) throws Throwable {
        jointheteampage.enterLocation(locate);
    }

    @When("^user click the search button$")
    public void user_click_the_search_button()  {
            jointheteampage.clickSearchButton();
    }

    @Then("^user should be able to view the results$")
    public void user_should_be_able_to_view_the_results() {
        if(jointheteampage.jobDetails()){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    //    Assert.assertTrue("Jobs listed", jointheteampage.jobDetails());
    }

    @And("^user click \"([^\"]*)\" button under \"([^\"]*)\"$")
    public void userClickButtonUnder(String buttonText, String jobName) {
        try {
            jointheteampage.clickReadMore(jobName);
        }catch (Exception e){
            System.out.println(e);
            Assert.fail();
        }

    }

    @Then("^user should be able to view the Senior QA Automation page$")
    public void user_should_be_able_to_view_the_Senior_QA_Automation_page() {
       if(driver.getTitle().contains("Senior QA Automation")){
       System.out.println("User is in "+driver.getTitle()+" page.");
       Assert.assertTrue(true);
       }else{
           Assert.fail();
       }
    }

    @When("^user enter \"([^\"]*)\" and click the search button$")
    public void user_enter_and_click_the_search_button(String keyValue)  {
        jointheteampage.enterKeyWord(keyValue);
        jointheteampage.clickSearchButton();
    }

    @When("^user click \"([^\"]*)\" button to select the document$")
    public void user_click_button_to_select_the_document(String buttonText) throws FindFailed, InterruptedException {
        jointheteampage.clickBrowseButton(buttonText);
    }

    @And("^user click \"([^\"]*)\" button$")
    public void userClickButton(String buttonText) {
        jointheteampage.clickSubmit(buttonText);
    }

    @Then("^user should get the success message \"([^\"]*)\"$")
    public void user_should_get_the_success_message(String textMessage) {
        if(jointheteampage.successMessage(textMessage)){
            Assert.assertTrue(true);
        }else{
           Assert.fail();
        }
     //  Assert.assertTrue("User successfully uploaded the document", jointheteampage.successMessage(textMessage));

    }

    @And("^user capture the image \"([^\"]*)\"$")
    public void userCaptureTheImage(String name)  {
      //  leadershippage.captureImage(name);
        System.out.println("Image Captured..");
    }

    @Then("^the \"([^\"]*)\" image should be same as expected$")
    public void theImageShouldBeSameAsExpected(String imageName) throws IOException {
        if(leadershippage.compareImage(imageName)){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
       // Assert.assertTrue("Images are compared >>", leadershippage.compareImage(imageName));
    }
}
