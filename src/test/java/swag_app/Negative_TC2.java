package swag_app;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;


import PageObjects.LoginPage;
import PageObjects.ProductPage;
import base.TestBase;
import config.ReadPropertyFile;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import listeners.TestAllureScreenshotListener;
//import pageObjects.FormPage;
//import pageObjects.checkoutPage;
import utils.AppiumServer;
import utils.WaitUtils;

@Listeners({TestAllureScreenshotListener.class})
public class Negative_TC2<Negative_TC2> extends TestBase{
	LoginPage loginpage;
	ProductPage productPage;
	WaitUtils waitutil;
	static ReadPropertyFile rp = new ReadPropertyFile();

	@BeforeClass
	 public void BeforeClass() {
	 /*AppiumServer.Start();*/
	 setUpDriver();
	 loginpage =new LoginPage(driver);
	 productPage=new ProductPage(driver);
	 waitutil= new WaitUtils();
	 }
 @Description("Test Description: Verify login Screen UI")
 @Severity(SeverityLevel.NORMAL)
 @Test
public void CheckoutPriceValidation() throws MalformedURLException, IOException, InterruptedException {

	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 loginpage.login(rp.readTestData("loginid"),rp.readTestData("password"));
	 int count= driver.findElementsByXPath("(//android.widget.TextView[@content-desc=\"test-Item title\"])").size();
		System.out.print(count);
		 String productPrice="";
		for(int i=0;i<count;i++)
	    {
	    String text=((RemoteWebElement) driver.findElementsByXPath("(//android.widget.TextView[@content-desc=\"test-Item title\"])").get(i)).getText();
	    System.out.print(text);
	   
		    if(text.equalsIgnoreCase("Sauce Labs Bike Light"))
		    {
		    	((RemoteWebElement) driver.findElementsByXPath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]").get(i)).click();
		    	 productPrice= ((RemoteWebElement) driver.findElementsByXPath("//android.widget.TextView[@content-desc=\"test-Price\"])").get(i)).getText();
		    	driver.findElementByXPath("//android.view.ViewGroup[@content-desc='test-Cart']").click();
			
		    }
	    }

		 System.out.println(driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Description\"]").getText());
		 String productPriceAfterChkout= driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Price\"]").getText();
		 productPage.checkoutElement.click();
	   // p.removeElement.click();
		 productPage.FirstNameElement.sendKeys(rp.readTestData("FirstName"));
		 productPage.lastNameElement.sendKeys(rp.readTestData("LastName"));
		 productPage.ZipCodeElement.sendKeys(rp.readTestData("ZipCode"));
		 productPage.continueElement.click();
	   
	   	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().className(android.view.ViewGroup)).scrollIntoView(new UiSelector().textMatches(\"FINISH\").instance(0))"));
	    productPage.finishElement.click();
	    String chkOutsuccessText=driver.findElementByXPath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]").getText();
	    Assert.assertEquals("CHECKOUT: COMPLETE!", chkOutsuccessText);
	   
		
		Assert.assertEquals(productPrice, productPriceAfterChkout);

}


	    
@AfterClass
public void AfterClass() {
tearDownDriver();
}

}


