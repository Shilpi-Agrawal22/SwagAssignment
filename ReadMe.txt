Framework Overview

-Its Maven & TestNg Framework -Framework having Page Object Model is developed to support both Android and IOS Mobile Application but focused on Android
and implemented Cucumber framework also on top of normal maven TestNG Framework.

Reporting:
Cucumber Report Path:Swag_APP_UI_Automation\target\cucumber-reports
TestNg Report:/Swag_APP_UI_Automation/test-output
About Test Script:/Swag_APP_UI_Automation/allure-results

Test Script: Create 3 Test Script
1. Negative Test case for login
2. E2E flow till checkout
3. Negative Testcase and application Defect. Even after removing the product from cart, User is Able to do Checkout Complete

Defect:Even after removeing the product able to checkout the product.

Test Data Configuration:

To Set TestData in Config folder can change Test Data.for the below fields that are used in script
For Cucumber Framework
Given Testdata in Respective Feature file
Example: 
      | UserName       |Password    |ErrorMessage   |
     
When Using Normal Maven TestNg
loginid=standard_user
password=secret_sauce
invalidLoginId=locked_out_user
FirstName=Shilpi
LastName=Agrawal
ZipCode=32456771

Configuration:
Emulator Capablity SetUp:
Need to change Emulator Properties in Config/config.properties file
PLATFORM=android
androidDeviceName=FirstEmulator<Emulator Name>
and Other Capabilities for device

To Run Project Prerequisite
1. Appium Should be installed on system
2. Appium Server should be started(Can be automatically started but Code commented as it depends on type of system Windows and Mac )
3. Emulator should be open and all emulator configuration is done(Emulator name/Device name should be given. Need small change in capabilitis to make irrespective of device/emulator)

Execution of Test Scripts: 1 Testcase will fail as It had defect
1. Cucumber TestRunner(Can run according to given tags. I used 2 tags @Smoke @Regression.)
2. Can run Automation suite using Testng.xml file
2. Using Maven commands
3. Respective Script using Run as TestNg test also
Maven commands to run project
$ mvn clean test

To get Allure results
$ allure serve target/allure-results

Scope of Improvement of Project:
1. After approach decided, Either Cucumber or Normal Test Framewok should be implemented
2. Can do more optimization of code/Reuse the Generic functions
3. Object implementaion could be more improvised used xpath as some of objects can't be find by using other properties and  used classpath to make xpath more reliable. FindByAll could be used to make more properties all together and to work in different environment.
4. Could be used hooks 

