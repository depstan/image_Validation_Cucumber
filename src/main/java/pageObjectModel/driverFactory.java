package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class driverFactory {

    public static WebDriver driver=null;

    public static WebDriver getDriver() {
        if(driver == null){
            driver=createDriver();
        }
        return driver;
    }

    private static WebDriver createDriver() {
        System.out.println("Initializing ChromeBrowser");
        File f=new File("Drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",f.getAbsolutePath());
        ChromeOptions opt=new ChromeOptions();
        opt.addArguments("start-maximized");
        opt.setExperimentalOption("useAutomationExtension", false);
        driver=new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public static void quitDriver(){
        if(driver!=null){
            driver.close();
            driver.quit();
            driver=null;
        }
    }

    public static void setDriver(WebDriver driver) {
        driverFactory.driver = driver;
    }


}
