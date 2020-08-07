package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class leadershipPage {

    public static WebDriver leadershipDriver;

    @FindBy(css = "#top-menu li#menu-item-14 a")
    public static WebElement leadershipTopMenu;
    @FindBy(css = "span.et_pb_image_wrap img[src*='gregCompressedEdited']")
    public static WebElement image_Greg;
    @FindBy(css = "span.et_pb_image_wrap img[src*='1Amy_FNL']")
    public static WebElement image_Amy;
    @FindBy(css = "span.et_pb_image_wrap img[src*='PaulIles']")
    public static WebElement image_Paul;

    public leadershipPage(WebDriver driver) {
        this.leadershipDriver = driver;
        PageFactory.initElements(leadershipDriver, this);
    }

    public static void clickleadershipMenu() {
        if (leadershipTopMenu != null) {
            genericUtilites.click(leadershipTopMenu);
        } else {
            Assert.fail("Element not present in the page >>");
        }
    }

    public static void checkleadershipMenu(){
        if(leadershipTopMenu != null){
            System.out.println("Leadership link found");
        }else {
            Assert.fail("Leadership link not found");
        }
    }

    public static boolean compareImage(String filename) throws IOException {
        BufferedImage expectedImage = ImageIO.read(new File("images/" + filename));

        //we can user List<WebElements> in case we need to iterate it over the leadership page with all the available image using a
        //WebElement for loop;
        Screenshot screen = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(leadershipDriver, image_Greg);
        BufferedImage actualImage = screen.getImage();

        //Comparing
        ImageDiffer differ = new ImageDiffer();
        ImageDiff diff = differ.makeDiff(expectedImage, actualImage);

        if (!diff.hasDiff()) {
            System.out.println("Images are same");
        } else {
            System.out.println("Images are not same");
            Assert.fail();
        }
        return true;

    }

    //Just for understanding I created a sample method, Main method used to capture all the images.
    public static void captureImage(String name) throws IOException, InterruptedException {
        Screenshot screen = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(leadershipDriver, image_Greg);
        ImageIO.write(screen.getImage(), "png", new File("images/" + name + ".png"));
        Thread.sleep(2000);
    }
}