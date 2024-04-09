package demo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        //driver.close();
         driver.quit();

    }

    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");

        // navigate to Google Forms link
        SeleniumWrapper.navigate(driver, "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");

        // Locate nameTextBox
        WebElement nameTextElement = driver.findElement(By.xpath("//div[@jscontroller='oCiKKc']//div[@class='Xb9hP']//input"));

        //Send values to nameTextBox using Selenium Wrapper method
        SeleniumWrapper.clickEnterText(nameTextElement, "Saajan Varghese");

        // Locate Practicing Automation TextBox
        WebElement practiceAutomation = driver.findElement(By.xpath("//div[@jscontroller='sWGJ4b']//textarea"));

        long epoch = System.currentTimeMillis()/1000;

        //Send values to Practicing Automation using Selenium Wrapper method
        SeleniumWrapper.clickEnterText(practiceAutomation, "I want to be the best QA Engineer! " + epoch);

        // Find and click on yearsofExperience by creating a list of Elements
        List<WebElement> radiobtnOptions = driver.findElements(By.xpath("//div[@class='nWQGrd zwllIb']//span"));

        String yearsofExperience = "0 - 2";

        for(int i = 0; i< radiobtnOptions.size(); i++){

            if(radiobtnOptions.get(i).getText().equals(yearsofExperience)){
                WebElement radioOption = driver.findElement(By.xpath("//div[@class='nWQGrd zwllIb']//span[text()='"+yearsofExperience+"']"));
                SeleniumWrapper.clickAction(radioOption, driver);s
            }
        }

        Thread.sleep(2000);

        // Find and click on CheckBoxes by creating a list of Elements
        List<WebElement> checkBoxbtnOptions = driver.findElements(By.xpath("//div[@class='eBFwI']//span"));

        String javaText = "Java";
        String SeleniumText = "Selenium";
        String TestNGText = "TestNG";

        for (int i = 0; i < checkBoxbtnOptions.size(); i++) {
            String text = checkBoxbtnOptions.get(i).getText();

            if (text.equals(javaText) || text.equals(SeleniumText) || text.equals(TestNGText)) {

                WebElement parentDiv = (WebElement) ((JavascriptExecutor) driver).executeScript(
                        "return arguments[0].parentNode;", checkBoxbtnOptions.get(i));

                WebElement javaCheckBox = parentDiv
                        .findElement(By.xpath("//div[@id='i30' and @data-answer-value='" + javaText + "']"));
                WebElement SeleniumCheckBox = parentDiv
                        .findElement(By.xpath("//div[@id='i33' and @data-answer-value='" + SeleniumText + "']"));
                WebElement TestNGCheckBox = parentDiv
                        .findElement(By.xpath("//div[@id='i39' and @data-answer-value='" + TestNGText + "']"));

                SeleniumWrapper.checkBoxClick(javaCheckBox, SeleniumCheckBox, TestNGCheckBox, driver);
                break;
            }
        }
        //Locate Select Tag
        WebElement selectTag = driver.findElement(By.xpath("//div[@jscontroller='liFoG']//div[@role='listbox']"));

        //Click on SelectTag
        selectTag.click();

        Thread.sleep(3000);

        // Locate Mr from Drop-Down TextBox
        WebElement SelectMr = driver.findElement(By.xpath("(//div[@jsname='wQNmvb']//span[text()='Mr'])[2]"));

        // Select Mr from Drop-Down TextBox
        SeleniumWrapper.clickAction(SelectMr, driver);

        Thread.sleep(1000);

        //Get the current Date and minus 7 Days  
        LocalDateTime myDateObj = LocalDateTime.now().minusDays(7);
        //Set pattern for the Date
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        //Converting Date to the pattern format
        String formatedDate = myDateObj.format(myFormatObj);
        System.out.println(formatedDate);

        //Locate Date field
        WebElement dateField = driver.findElement(By.xpath("//input[@type='date']"));
        //Clear Date field
        dateField.clear();

        Thread.sleep(3000);

        //Send formated date as value
        dateField.sendKeys(formatedDate);
        //Press Enter Key 
        dateField.sendKeys(Keys.ENTER);

        // Get Current Time
       LocalTime myObj = LocalTime.now();

       System.out.println(myObj);

       //Set pattern for Time
       DateTimeFormatter myFormatHourObj = DateTimeFormatter.ofPattern("HH");
       //Set pattern for Time
       DateTimeFormatter myFormatMinuteObj = DateTimeFormatter.ofPattern("mm");

       //Convert Time to the pattern format
       String formatedHour = myObj.format(myFormatHourObj);

       //Convert Time to the pattern format
       String formatedMinute = myObj.format(myFormatMinuteObj);

       //Locate Hours TextBox
       WebElement hours = driver.findElement(By.xpath("(//input[@type='text'])[2]"));

       //Locate Minutes TextBox
       WebElement minutes = driver.findElement(By.xpath("(//input[@type='text'])[3]"));

       // Enter Time
       SeleniumWrapper.EnterTimeField(hours, minutes, formatedHour, formatedMinute);

       // Locate submit button
       WebElement submitbtn = driver.findElement(By.xpath("//span[text()='Submit']"));

       // Click on Submit button
       submitbtn.click();

       Thread.sleep(3000);

       // Find Element
       WebElement resultText = driver.findElement(By.xpath("//div[text()='Thanks for your response, Automation Wizard!']"));

       // Get the ElementText in a String
       String getResultElementtxt = resultText.getText();

       // Declaring Expected String
       String resultElementText = "Thanks for your response, Automation Wizard!";

       //Verifying Element String with Expected String
       if(getResultElementtxt.equals(resultElementText)){
        System.out.println("Verified Text: "+resultElementText);
       }
       else{
        System.out.println("ResultText not Verifed");
        driver.close();
       }

       System.out.println("end Test case: testCase01");
       endTest();
    }
}