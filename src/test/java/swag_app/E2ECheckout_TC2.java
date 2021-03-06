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

import PageObjects.CheckoutPage;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import base.TestBase;
import config.ReadPropertyFile;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//import io.qameta.allure.Description;
//import io.qameta.allure.Severity;
//import io.qameta.allure.SeverityLevel;
import listeners.TestAllureScreenshotListener;
//import pageObjects.FormPage;
//import pageObjects.checkoutPage;
import utils.AppiumServer;
import utils.WaitUtils;

@Listeners({TestAllureScreenshotListener.class})
public class E2ECheckout_TC2 extends TestBase{
	LoginPage loginpage;
	ProductPage productPage;
	CheckoutPage checkoutPage;
	WaitUtils waitutil;
	static ReadPropertyFile rp;

	@BeforeClass
	 public void BeforeClass() {
	 /*AppiumServer.Start();*/
	 setUpDriver();
	 rp = new ReadPropertyFile();
	 loginpage =new LoginPage(driver);
	 productPage=new ProductPage(driver);
	 checkoutPage= new CheckoutPage(driver);
	 waitutil= new WaitUtils();
	 }

 @Test
public void CheckoutPriceValidation() throws MalformedURLException, IOException, InterruptedException {

	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 loginpage.login(rp.readTestData("loginid"),rp.readTestData("password"));
	 productPage.verifySuccessfulLogin();
	 int count= productPage.productElements.size();
		System.out.print(count);
		 String productPrice="";

		for(int i=0;i<count;i++)
	    {
	   
			String text=productPage.productElements3.get(i).getText();
			
			System.out.print(text);
	   
		    if(text.equalsIgnoreCase("Sauce Labs Bike Light"))
		    {			    	
		    	
		    	productPage.productAddToCartElements.get(i).click();	    	
		    	productPage.productCartEle.click();
		    }
	    }

		 String productPriceAfterChkout= driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Price\"]").getText();
		 System.out.println("Product Price"+productPriceAfterChkout);
		 productPage.checkoutElement.click();
	  
		 checkoutPage.FirstNameElement.sendKeys(rp.readTestData("FirstName"));
		 checkoutPage.lastNameElement.sendKeys(rp.readTestData("LastName"));
		 checkoutPage.ZipCodeElement.sendKeys(rp.readTestData("ZipCode"));
		 checkoutPage.continueElement.click();
	   
	   	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().className(android.view.ViewGroup)).scrollIntoView(new UiSelector().textMatches(\"FINISH\").instance(0))"));
	   	checkoutPage.finishElement.click();	 
	   
	    checkoutPage.verifySuccessfulCheckOut();
	    		


}


	    
@AfterClass
public void AfterClass() {
	tearDownDriver();
}

}


