package swag_app;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import base.TestBase;
import config.ReadPropertyFile;
import listeners.TestAllureScreenshotListener;
import PageObjects.ProductPage;
import PageObjects.LoginPage;
import utils.AppiumServer;
//import io.qameta.allure.Description;
//import io.qameta.allure.Severity;
//import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;


@Listeners({TestAllureScreenshotListener.class})
public class NegativeLoginTest extends TestBase {

	LoginPage loginPage;
	static ReadPropertyFile rp = new ReadPropertyFile();
 @BeforeClass
 public void BeforeClass() {
 /*AppiumServer.Start();*/
 setUpDriver();
 
 loginPage = new LoginPage(driver);
 }

 @Test(priority = 1)
 //@Description("Test Description: Verify login Screen UI with locked out User")
 //@Severity(SeverityLevel.NORMAL)
 public void TC01_verifyLoginUI() {
 LOGGER.info("************** Running test case : TC01_verifyLoginUI **************");

 	loginPage.login(rp.readTestData("invalidLoginId"),rp.readTestData("password"));

 	String errMessage= loginPage.getErrorMessage();
 	System.out.print("Error message is coming when entering locked username password are entered"+errMessage);
 	Assert.assertEquals(errMessage,"Sorry, this user has been locked out.");
 	
 }

 @AfterClass
 public void AfterClass() {
 tearDownDriver();
 }
}