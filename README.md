# Google Forms Automation

# Description
The Application Under Test is Google Forms Automation.

The Aim of this project is to Enter Values for WebElements present in the Google form and Submit the Google Form.

This Google Form consists of Textbox, radio-button, checkBox, DateElement, Drop-down textBox.

Written code in such a way that values are passed for each WebElement and  Submit the Google Form.

For some WebElements, values are passed with some conitions
1. For "Why are you Practicing Automation?" Field, we have to pass an input along with a variable value.
 
2. For Date Field - Provided the current date minus 7 days in the date field, it should be dynamically calculated and not hardcoded.

3. For "What is the Time Now?" -Provide the current time (Keeping in mind AM/PM) in the next field.

This Google Forms Automation project consists of 1 Testcase in Total.

# TestCase 01 Description
1. Navigate to this google form.

2. Fill in your name in the 1st text box.

3. Write down “I want to be the best QA Engineer! 1710572021'' where 1710572021 is variable - needs to be the current epoch time.

4. Enter your Automation Testing experience in the next radio button

5. Select Java, Selenium and TestNG from the next check-box.

6. Provide how you would like to be addressed in the next dropdown.

7. Provided the current date minus 7 days in the next date field, it should be dynamically calculated and not hardcoded.

8. Provide the current time (Keeping in mind AM/PM) in the next field.

9. Change the URL of the tab (amazon.in) and you will find the pop up as follows. Click on cancel. (Optional)

10. Submit the form.

11. You will see a success message on the website. Print the same message on the console upon successful completion.

# Note on This Google Forms Automation Project
1. Added Selenium Wrapper Methods

## Required Software to Install:
```
# java version 17
java --version
```
```
# git version 2.43.0
git --version
```
```
# gradle version 8.6
gradle --version
```
```
# vscode 1.88.1
git --version
```
## Required Dependency to run:
```
# WebDriverManager
# Selenium
```
## Instructions to Run the Code:
```
# to build the project
gradle build
```
```
# to run the project
gradle run
```
```
# to test the project
gradle test
```