package pageObjectModel;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;

public class genericUtilites {

    public static void click(WebElement element){
        if(element != null) {
            element.click();
        }else {
            Assert.fail("Element is null");
        }

    }


    public static String getText(WebElement element){
        if(element != null){
            String str=element.getText();
            return str;

        }else{
            System.out.println("Element is null");
            return null;
        }

    }

    public static String getAttribute(WebElement element, String text){
        String str=element.getAttribute(text);
        return str;
    }

    public static void clear(WebElement element){
        if(element != null) {
            element.clear();
        }else {
            Assert.fail("Element is null");
        }

    }

    public static void selectDropDownwithVisibleTest(String text, WebElement element){
        Select slt=new Select(element);
        slt.selectByVisibleText(text);
    }

    public static void selectDropDownwithValue(String text, WebElement element){
        if(element != null) {
            Select slt = new Select(element);
            slt.selectByValue(text);
        }else{
            Assert.fail("Element is null");
        }
    }

    public static void selectDropDownwithIndex(int value, WebElement element){
        Select slt=new Select(element);
        slt.selectByIndex(value);
    }

}
