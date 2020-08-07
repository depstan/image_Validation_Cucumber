package pageObjectModel;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.*;
import org.testng.*;

import java.util.List;

import static org.testng.AssertJUnit.fail;

public class joinTheTeamPage {
    public static WebDriver jointheteamDriver;
    @FindBy(css="div.et_pb_text_inner >h1 >span")   public static WebElement joinTeamPageTitle;
    @FindBy(css="input#keywords")                   public static WebElement keywordField;
    @FindBy(css = "input.btn-search.btn-primary")   public static WebElement searchButton;
    @FindBy(css = "#category")                      public static WebElement categoryDropDown;
    @FindBy(css = "#jobtype" )                      public static WebElement jobtypeDropDown;
    @FindBy(css =  "location")                      public static WebElement locationDropDown;
    @FindBys(@FindBy(css = "span.job-title"))       public static List<WebElement> jobTitle;
    @FindBy(css = "ul#top-menu li >a[href*='join-the-team']") public static WebElement jointheteamTopMenu;

    @FindBy(css = "input#applicant-resume")  public static WebElement browseButton;
    @FindBy(css = "#sjb-form-padding-button button")    public static WebElement submitButton;
    @FindBy(css = "#file-error-message")  public static WebElement failureError;
    //Your application has been received. We will get back to you soon.
    @FindBy(css = "div.alert.alert-success")    public static WebElement finalMessage;
    //p>a.btn.btn-primary[href*="automation"]  this is for ReadMore web element

    public joinTheTeamPage(WebDriver driver) {
        this.jointheteamDriver=driver;
        PageFactory.initElements(jointheteamDriver, this);
    }

    public static void enterKeyWord(String text){
        genericUtilites.clear(keywordField);
        keywordField.sendKeys(text);
    }

    public static void  clickjointheTeamMenu(){
        if(jointheteamTopMenu != null){
            genericUtilites.click(jointheteamTopMenu);
        }else {
            Assert.fail("Element not present in the page >>");
        }
    }

    public static void checkJoinTheTeamMenu(){
        if(jointheteamTopMenu != null){
            System.out.println("Join The Team link found");
        }else {
            Assert.fail("Join The Team link not found");
        }
    }

    public static void enterCategory(String text){
        genericUtilites.selectDropDownwithValue(text,categoryDropDown);
    }

    public static void enterJobType(String text){
        genericUtilites.selectDropDownwithValue(text,jobtypeDropDown);
    }

    public static void enterLocation(String text){
        genericUtilites.selectDropDownwithValue(text,locationDropDown);
    }

    public static void clickSearchButton(){
        genericUtilites.click(searchButton);
    }

    public static String getPageTitle(){
        String str=jointheteamDriver.getTitle();
        return str;
    }

    public static boolean jobDetails() {
        if (jobTitle.isEmpty()) {
            System.out.println("No jobs listed..");
            return false;
        } else {
            System.out.println("jobs listed");
            for(WebElement ele: jobTitle){
                System.out.println(ele.getText());
            }
            return true;
        }

    }

    public static void clickReadMore(String jobName){
        String str=jobName.toLowerCase().trim().replaceAll(" ","-");
        WebElement readMore=jointheteamDriver.findElement(By.cssSelector("a[href*="+str+"].btn.btn-primary"));
        genericUtilites.click(readMore);
    }

    public static void clickBrowseButton(String button) throws InterruptedException, FindFailed {
        genericUtilites.click(browseButton);
        System.out.println("User clicked >>"+button);
        Screen src=new Screen();

        Pattern fileinput=new Pattern("C:\\Users\\DepstanT\\IdeaProjects\\myhealthbridge\\imagesikuli\\fileInput.png");
        Pattern openclick=new Pattern("C:\\Users\\DepstanT\\IdeaProjects\\myhealthbridge\\imagesikuli\\openClick.png");

        Thread.sleep(2000);
        src.wait(fileinput, 10);
        src.type(fileinput, "C:\\Users\\DepstanT\\Desktop\\testSample.docx");
        src.click(openclick);

    }

    public  static void clickSubmit(String text){
        genericUtilites.click(submitButton);
        System.out.println("User click >>" +text);
    }

    public static boolean successMessage(String text){
        if((finalMessage.getText()).contains(text)){
            System.out.println(finalMessage.getText());
            return true;
        }else{
            System.out.println("Error message -- " +finalMessage.getText());
            return false;
        }

    }
}
