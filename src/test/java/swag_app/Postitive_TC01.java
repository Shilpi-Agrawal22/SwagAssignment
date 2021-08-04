package swag_app;

import static java.time.Duration.ofSeconds;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.ProductPage;

import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import  static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//import pageObjects.FormPage;
//import pageObjects.checkoutPage;
import utils.AppiumServer;

public class Postitive_TC01 extends ecommerceCapability{

@Test
public void Checkout() throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
	
		AndroidDriver<AndroidElement> driver= Capabilities("SwagApp");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
		LoginPage loginpage=new LoginPage(driver);
		ProductPage productPage=new ProductPage(driver);
		
		loginpage.login("standard_user","secret_sauce");
		

		int count= driver.findElementsByXPath("(//android.widget.TextView[@content-desc=\"test-Item title\"])").size();
		System.out.print(count);
		for(int i=0;i<count;i++)
	    {
	    String text=driver.findElementsByXPath("(//android.widget.TextView[@content-desc=\"test-Item title\"])").get(i).getText();
	    System.out.print(text);
	    if(text.equalsIgnoreCase("Sauce Labs Bike Light"))
	    {
	    	driver.findElementsByXPath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]").get(i).click();
	    	driver.findElementByXPath("//android.view.ViewGroup[@content-desc='test-Cart']").click();
		
	    }
	    }

		 System.out.println(driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Description\"]").getText());
		
		 productPage.checkoutElement.click();
	   // p.removeElement.click();
		 productPage.FirstNameElement.sendKeys("ABC");
		 productPage.lastNameElement.sendKeys("ABC");
		 productPage.ZipCodeElement.sendKeys("ABC");
		 productPage.continueElement.click();
	    driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().className(android.view.ViewGroup)).scrollIntoView(new UiSelector().textMatches(\"FINISH\").instance(0))"));
	    productPage.finishElement.click();
	    System.out.println(driver.findElementByXPath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]").getText());

	    }
}


