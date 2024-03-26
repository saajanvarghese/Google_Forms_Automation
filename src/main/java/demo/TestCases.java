package demo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException{

        System.out.println("Start Test case: testCase01");
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");

        WebElement nameTextElement = driver.findElement(By.xpath("//div[@jscontroller='oCiKKc']//div[@class='Xb9hP']//input"));

        SeleniumWrapper.clickEnterText(nameTextElement, "Saajan Varghese");
        System.out.println("end Test case: testCase02");

        WebElement practiceAutomation = driver.findElement(By.xpath("//div[@jscontroller='sWGJ4b']//textarea"));

        long epoch = System.currentTimeMillis()/1000;

        SeleniumWrapper.clickEnterText(practiceAutomation, "I want to be the best QA Engineer! " + epoch);

        //Thread.sleep(10000);

        WebElement experienceOptions = driver.findElement(By.xpath("//div[@class='nWQGrd zwllIb']//div[@id='i13' and @data-value = '0 - 2']"));

        SeleniumWrapper.clickAction(experienceOptions, driver);

        WebElement javaCheckBox = driver.findElement(By.xpath("//div[@class='eBFwI']//div[@id='i30' and @data-answer-value= 'Java']"));

        SeleniumWrapper.clickAction(javaCheckBox, driver);

        WebElement SeleniumCheckBox = driver.findElement(By.xpath("//div[@class='eBFwI']//div[@id='i33' and @data-answer-value= 'Selenium']"));

        SeleniumWrapper.clickAction(SeleniumCheckBox, driver);

        WebElement TestNGCheckBox = driver.findElement(By.xpath("//div[@class='eBFwI']//div[@id='i39' and @data-answer-value= 'TestNG']"));

        SeleniumWrapper.clickAction(TestNGCheckBox, driver);

        WebElement selectTag = driver.findElement(By.xpath("//div[@jscontroller='liFoG']//div[@role='listbox']"));

        selectTag.click();

        Thread.sleep(3000);

        WebElement SelectMr = driver.findElement(By.xpath("(//div[@jsname='wQNmvb']//span[text()='Mr'])[2]"));

        SeleniumWrapper.clickAction(SelectMr, driver);

        Thread.sleep(1000);

        LocalDateTime myDateObj = LocalDateTime.now().minusDays(7);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String formatedDate = myDateObj.format(myFormatObj);
        System.out.println(formatedDate);

        WebElement dateField = driver.findElement(By.cssSelector("input[type='date']"));

        dateField.clear();

        Thread.sleep(3000);

        dateField.sendKeys(formatedDate);
        dateField.sendKeys(Keys.ENTER);
       

       LocalTime myObj = LocalTime.now();

       System.out.println(myObj);

       DateTimeFormatter myFormatHourObj = DateTimeFormatter.ofPattern("HH");

       DateTimeFormatter myFormatMinuteObj = DateTimeFormatter.ofPattern("mm");

       String formatedHour = myDateObj.format(myFormatHourObj);

       String formatedMinute = myDateObj.format(myFormatMinuteObj);

       WebElement hours = driver.findElement(By.xpath("(//input[@type='text'])[2]"));

       WebElement minutes = driver.findElement(By.xpath("(//input[@type='text'])[3]"));

       SeleniumWrapper.clickEnterText(hours, formatedHour);

       SeleniumWrapper.clickEnterText(minutes, formatedMinute);

       WebElement submitbtn = driver.findElement(By.xpath("//span[text()='Submit']"));

       submitbtn.click();

       Thread.sleep(3000);

       WebElement resultText = driver.findElement(By.xpath("//div[text()='Thanks for your response, Automation Wizard!']"));

       System.out.println(resultText.getText());
    }
}
