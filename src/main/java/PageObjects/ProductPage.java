package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
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
	
	
	



	

}
