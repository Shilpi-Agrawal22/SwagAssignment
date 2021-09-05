package stepDefinations;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import PageObjects.CheckoutPage;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import base.TestBase;

/*import com.appium.base.BaseClass;
import com.appium.screens.BankingScreen;
import com.appium.screens.MarketPlaceHomeScreen;
import com.appium.screens.RegistrationScreen;
import com.appium.utils.CommonUtils;*/


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import cucumber.api.java.en.And;

public class ProductCheckoutStepDef extends TestBase {
	public static final Logger log = Logger.getLogger(ProductCheckoutStepDef.class);
	
	LoginPage loginpage= new LoginPage(driver);
	ProductPage productPage;
	CheckoutPage checkoutPage;
	 String productPriceAfterChkout;
	 String productPrice="";
    @Given("^Already registered customer$")
    public void already_registered_customer() throws Throwable {
    	 productPage=new ProductPage(driver);
    	 productPage.verifySuccessfulLogin();
    }

    //@When("^Search Product (.+) in the list of Product displayed on Product screen$")
    @When("^Search Product (.+) in the list of Product displayed on Product screen and Click on ADD TO CART$")
    public void search_product_in_the_list_of_product_displayed_on_product_screen(String product) throws Throwable {
    	int count= productPage.productElements.size();
    	
    	
		System.out.print(count);
		for(int i=0;i<count;i++)
	    {
			String text=productPage.productElements.get(i).getText();
			System.out.print(text);
			
			if(text.equalsIgnoreCase(product))
		    {
		    	productPage.productAddToCartElements.get(i).click();
		    	productPage.productCartEle.click();
		    }
	    }
    }
    @Then("^User must be re-directed to the product description page$")
    public void user_must_be_redirected_to_the_product_description_page() throws Throwable {
    	 productPage.checkoutElement.click();
    }

    @And("^Click on ADD TO CART $")
    public void click_on_add_to_cart() throws Throwable {
        
    }

    @And("^Click Cart Button$")
    public void click_cart_button() throws Throwable {
        
    }
    @And("^Click on REMOVE button on Your Cart Page$")
    public void click_on_remove_button_on_your_cart_page() throws Throwable {
    	Thread.sleep(1000);
    	productPage.removeElement.click();
    	//driver.findElementByAccessibilityId("test-REMOVE").click();
    	//TouchAction touchAction = new TouchAction(driver);
        //touchAction.tap(tapOptions().withElement(element(productPage.removeElement))).perform().release();
    	 //driver.findElementByAccessibilityId("test-REMOVE").click();
    	 
    }

    @And("^Added product (.+)  must appear$")
    public void added_product_must_appear(String product) throws Throwable {
        
    }

    @And("^Click the CHECKOUT button$")
    public void click_the_checkout_button() throws Throwable {
       
    }

    @And("^CHECKOUT INFORMATION page is displayed $")
    public void checkout_information_page_is_displayed() throws Throwable {
       
    }

    @And("^Enter Checkout Information (.+), (.+), (.+)$")
    public void enter_checkout_information_(String firstname, String lastname, String zipcode) throws Throwable {
    	checkoutPage= new CheckoutPage(driver);
    	checkoutPage.FirstNameElement.sendKeys(firstname);
		 checkoutPage.lastNameElement.sendKeys(lastname);
		 checkoutPage.ZipCodeElement.sendKeys(zipcode);
		
    }

    @And("^Click Continue Button$")
    public void click_continue_button() throws Throwable {
    	 checkoutPage.continueElement.click();
    }

    @And("^Checkout Overview Screen is dispalyed$")
    public void checkout_overview_screen_is_dispalyed() throws Throwable {
       
    }

    @And("^Product (.+) is displayed$")
    public void product_is_displayed(String product) throws Throwable {
       
    }

    @And("^Click on Finish Button$")
    public void click_on_finish_button() throws Throwable {
    	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().className(android.view.ViewGroup)).scrollIntoView(new UiSelector().textMatches(\"FINISH\").instance(0))"));
	   	checkoutPage.finishElement.click();
    }

    @And("^Checkout Complete Screen is dispalyed$")
    public void checkout_complete_screen_is_dispalyed() throws Throwable {
    	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().className(android.view.ViewGroup)).scrollIntoView(new UiSelector().textMatches(\"FINISH\").instance(0))"));
	   	checkoutPage.finishElement.click();
    }
    @Then("^User should be successfully logged in$")
    public void user_should_be_successfully_logged_in() throws Throwable {
    	productPage=new ProductPage(driver);
    	 productPage.verifySuccessfulLogin();
    }
    @Then("^Verify Checkout Button should be disabled$")
    public void verify_checkout_button_should_be_disabled() throws Throwable {
    	checkoutPage= new CheckoutPage(driver);
    	checkoutPage.verifyCheckOutButtonDisabled();
    }
}
