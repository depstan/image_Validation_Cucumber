package pageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myHealthBridge {
    public static WebDriver myhealthdriver;

    @FindBy(css = "ul#top-menu >li#menu-item-14 >a")    public static WebElement leadershiplink;
    @FindBy(css = "ul#top-menu >li#menu-item-1893 >a")  public static WebElement jointheteam;
    @FindBy(css = "img#logo")                           public static WebElement logoimage;

    public myHealthBridge(WebDriver driver) {
        this.myhealthdriver=driver;
        PageFactory.initElements(myhealthdriver, this);
    }

    public static void clickJoinTheTeam(){
        genericUtilites.click(jointheteam);
    }

    public static String tagnameJoinTheTeam(){
        String tag=genericUtilites.getText(jointheteam);
        return tag;
    }

    public static void clickLeadershipLink(){
        genericUtilites.click(leadershiplink);
    }

    public static String tagnameLeadershipLink(){
        String tag=genericUtilites.getText(leadershiplink);
        return tag;
    }

    public static boolean homePageImage(){
        Boolean imagePresent= (Boolean) ((JavascriptExecutor)myhealthdriver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", logoimage);
        if (imagePresent)
        {
            return true;
        }
        else
        {
            return false;
        }

    }



}
