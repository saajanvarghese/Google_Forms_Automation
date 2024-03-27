# Project Name: Google Forms Automation

## Google Forms Automation
# Description
The Application Under Test is Google Forms Automation.

The Aim of this project is to Enter Values for WebElements present in the Google form and Submit the Google Form.

This Google Form consists of Textbox, radio-button, checkBox, DateElement, Drop-down textBox.

Written code in such a way that values are passed for each WebElement and  Submit the Google Form.

For some WebElements, values are passed with some conitions
1. For "Why are you Practicing Automation?" Field, we have to pass an input along with a variable value,
2. For Date Field - Provided the current date minus 7 days in the date field, it should be dynamically calculated and not hardcoded.
3. For "What is the Time Now?" -Provide the current time (Keeping in mind AM/PM) in the next field.

## Installation Instructions:
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
# vscode 1.87.2
git --version
```
## Dependency Required:
```
# WebDriverManager
# Selenium
```
## Usage and Examples:
```
# to build the project
gradlew build
```

```
# to run the project
gradlew run
```