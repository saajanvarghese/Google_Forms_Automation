package demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumWrapper {

    public static boolean clickEnterText(WebElement inputBox, String keysToSend){
        try {
            inputBox.click();
            inputBox.clear();
            inputBox.sendKeys(keysToSend);
            Thread.sleep(1000);
            return true;
            
        } catch (Exception e) {
            // TODO: handle exception
            return false;
            
        }

    }

    public static boolean clickAction(WebElement element, WebDriver driver){
        if(element.isDisplayed()){
            try {
                JavascriptExecutor js=(JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true)", element);
                element.click();
                Thread.sleep(2000);
                return true;
            } catch (Exception e) {
                // TODO: handle exception
                return false;
            }
        }
        return false;
    }

    public static boolean navigate(WebDriver driver, String url){
        try {
            if(driver.getCurrentUrl().equals(url)){
                return true;
            }
            else{
                driver.get(url);
                return driver.getCurrentUrl().equals(url);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public static void setDateUsingJavaScript(WebDriver driver, WebElement element, String dateValue) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', arguments[1])", element, dateValue);
    }
}
