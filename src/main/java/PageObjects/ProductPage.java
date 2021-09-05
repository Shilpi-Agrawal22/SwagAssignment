package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage {
	public ProductPage(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(accessibility="test-CHECKOUT")
	public WebElement checkoutElement;
	@AndroidFindBy(accessibility="test-REMOVE")
	public WebElement removeElement;
	@AndroidFindBy(accessibility="test-CONTINUE")
	public WebElement continueElement;
	@AndroidFindBy(accessibility="test-First Name")
	public WebElement FirstNameElement;
	@AndroidFindBy(accessibility="test-Last Name")
	public WebElement lastNameElement;
	@AndroidFindBy(accessibility="test-Zip/Postal Code")
	public WebElement ZipCodeElement;
	@AndroidFindBy(accessibility="test-FINISH")
	public WebElement finishElement;
	
	/*************************/
	@AndroidFindBy(accessibility="test-Cart drop zone")
	public WebElement productPageParentObj;
	/*****/
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"PRODUCTS\"]")
	public WebElement productPageHeader;
	/*******************/
	 @AndroidFindBy(className="android.widget.TextView")
	public WebElement productPageproductHeader;
	 /******/
	//driver.findElementsByXPath("(//android.widget.TextView[@content-desc=\"test-Item title\"])").size();
	@AndroidFindBy(xpath="(//android.widget.TextView[@content-desc=\"test-Item title\"])")
	public List<WebElement> productElements;
	
	@AndroidFindBy(accessibility="test-Item title")
	public List<WebElement> productElements3;
	/*************************/
	@AndroidFindBy(accessibility="test-PRODUCTS")
	public List<WebElement> productElements2;
	/*************************/
	
	@AndroidFindBy(accessibility="test-ADD TO CART")
	public List<WebElement> productAddToCartElements;
	
	@AndroidFindBy(accessibility="test-Price")
	public List<WebElement> productPriceElements;
	
	@AndroidFindBy(accessibility="test-Cart")
	public WebElement productCartEle;
	
	
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='test-Cart']")
	public WebElement productCartEle2;

	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]")
	public List<WebElement> productAddToCartElements2;
	

	@AndroidFindBy(xpath="android.widget.TextView[@content-desc=\"test-Price\"]")
	public List<WebElement> productPriceElements2;
	

	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-Description\"]")
	public WebElement productTestDescriptionEle;
	
	//@AndroidFindAll(priority=, value = { @AndroidBy })
	//public WebElement productPageElement;
	public void verifySuccessfulLogin () {
        System.out.println("implement Login successful");
        Assert.assertTrue(productPageHeader.isDisplayed());
    }
	
	

	



	

}
