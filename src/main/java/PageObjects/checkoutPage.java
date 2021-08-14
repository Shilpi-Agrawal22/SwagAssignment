package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage {
	public CheckoutPage(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"))
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productLists;
	@AndroidFindBy(accessibility="test-First Name")
	public WebElement FirstNameElement;
	@AndroidFindBy(accessibility="test-Last Name")
	public WebElement lastNameElement;
	@AndroidFindBy(accessibility="test-Zip/Postal Code")
	public WebElement ZipCodeElement;
	@AndroidFindBy(accessibility="test-FINISH")
	public WebElement finishElement;
	@AndroidFindBy(accessibility="test-CONTINUE")
	public WebElement continueElement;
	@AndroidFindBy(accessibility="test-CHECKOUT")
	public WebElement checkoutElement;
	@AndroidFindBy(accessibility="test-REMOVE")
	public WebElement chkRemoveElement;
	//driver.findElementByXPath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]")
	//driver.findElementByXPath("//android.widget.TextView[@text=\"CHECKOUT: COMPLETE!\"]")
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"CHECKOUT: COMPLETE!\"]")
	public WebElement checkoutCompleteMesEle;
	
	public void verifySuccessfulCheckOut () {
       
        Assert.assertTrue(checkoutCompleteMesEle.isDisplayed());
    }
	public void verifyCheckOutButtonDisabled () {
	       
        Assert.assertFalse(checkoutElement.isEnabled());
    }
	
}
