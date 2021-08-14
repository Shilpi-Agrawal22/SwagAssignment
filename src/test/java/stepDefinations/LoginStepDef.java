package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import base.TestBase;
/*import com.appium.base.BaseClass;
import com.appium.screens.BankingScreen;
import com.appium.screens.MarketPlaceHomeScreen;
import com.appium.screens.RegistrationScreen;
import com.appium.utils.CommonUtils;*/
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/*import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;*/
public class LoginStepDef extends TestBase {
	public static final Logger log = Logger.getLogger(LoginStepDef.class);
	//MarketPlaceHomeScreen mp = new MarketPlaceHomeScreen(appDriver);
	LoginPage loginPage;
	String actualErrMessage;
	 @Given("^Launch the Application$")
	    public void launch_the_application() throws Throwable {
		 setUpDriver();
	    }

	   /*@When("^Enter credentials username as (.+) and password as (.+) and login application$")
	   public void enter_credentials_username_as_and_password_as_and_login_application(String username, String password) throws Throwable {
	    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	System.out.println(username);
	    	System.out.println(password);
	    	loginPage = new LoginPage(driver);
	    	loginPage.login(username,password);
	    }*/
	
	 @When("^Enter credentials username as \"([^\"]*)\" and password as \"([^\"]*)\" and login application$")
	   public void enter_credentials_username_as_and_password_as_and_login_application(String username, String password) throws Throwable {
	    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	System.out.println(username);
	    	System.out.println(password);
	    	loginPage = new LoginPage(driver);
	    	loginPage.login(username,password);
	    }

	    @Then("^An error message should be dsiplayed for invalid credentials$")
	    public void an_error_message_should_be_dsiplayed_for_invalid_credentials() throws Throwable {
	    	//loginPage = new LoginPage(driver);
	    	actualErrMessage= loginPage.errMessage();
	     	System.out.print("Error message is coming when entering locked username password are entered"+actualErrMessage);
	    }

	    @And("^Verify the Error message (.+)$")
	    public void verify_the_error_message(String errormessage) throws Throwable {
	    	System.out.print("\nActual Error message is coming "+actualErrMessage);
	    	Assert.assertEquals(actualErrMessage,errormessage);
	    }
	    
	   


}
