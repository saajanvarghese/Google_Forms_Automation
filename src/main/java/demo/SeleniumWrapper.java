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
                Thread.sleep(1000);
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
                Thread.sleep(2000);
                return true;
            }
            else{
                driver.get(url);
                Thread.sleep(2000);
                return driver.getCurrentUrl().equals(url);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public static boolean checkBoxClick(WebElement checkBox1, WebElement checkBox2, WebElement checkBox3, WebDriver driver){
        if(checkBox1.isDisplayed() || checkBox2.isDisplayed() || checkBox3.isDisplayed()){
            try {
                JavascriptExecutor js=(JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true)", checkBox1);
                js.executeScript("arguments[0].scrollIntoView(true)", checkBox2);
                js.executeScript("arguments[0].scrollIntoView(true)", checkBox3);
                Thread.sleep(2000);
                checkBox1.click();
                Thread.sleep(2000);
                checkBox2.click();
                Thread.sleep(2000);
                checkBox3.click();
                Thread.sleep(2000);
                return true;
            } catch (Exception e) {
                // TODO: handle exception
                return false;
            }
        }
        return false;
    }

    public static boolean EnterTimeField(WebElement inputBox, WebElement inputBox2, String keysToSend, String SendKeys){
        try {
            inputBox.click();
            inputBox.clear();
            inputBox.sendKeys(keysToSend);
            Thread.sleep(1000);
            inputBox2.click();
            inputBox2.clear();
            inputBox2.sendKeys(SendKeys);
            return true;
            
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
