package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class TestClass {

    public static void main(String[] str) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://myhealthbridge.com/");
        driver.manage().window().maximize();
        String title=driver.getTitle();
        System.out.println(title);
        driver.findElement(By.cssSelector("#top-menu li#menu-item-14 a")).click();
        Thread.sleep(1000);
        WebElement element=driver.findElement(By.cssSelector("span.et_pb_image_wrap img[src*='PaulIles']"));
        Screenshot screen=new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, element);
        ImageIO.write(screen.getImage(),"png",new File("images/Paul.png"));
        Thread.sleep(2000);
        driver.quit();

    }
}
