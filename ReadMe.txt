Framework Overview

-Its Maven & TestNg Framework -Framework having Page Object Model is developed to support both Android and IOS Mobile Application but focused on Android
and Allure Report is implemented.

About Test Script:
3 Test Script
1. Negative Test case for login
2. E2E flow till checkout

Defect:Even after removeing the product able to checkout the product.

Test Data Configuration:

To Set TestData in Config folder can change Test Data.for the below fields that are used in script
loginid=standard_user
password=secret_sauce
invalidLoginId=locked_out_user
FirstName=Shilpi
LastName=Agrawal
ZipCode=32456771

Emulator Capablity SetUp:
Need to change Emulator Properties in Config/config.properties file
PLATFORM=android
androidDeviceName=FirstEmulator<Emulator Name>
and Other Capabilities for device

To Run Project Prerequisite
1. Appium Should be installed on system
2. Appium Server should be started
3. Emulator should be open and all emulator configuration is done

Execution of Test Scripts:
1. Can run Automation suite using Testng.xml file
2. Using Maven commands
3. Respective Script using Run as TestNg test also
Maven commands to run project
$ mvn clean test

To get Allure results
$ allure serve target/allure-results
