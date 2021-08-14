package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	//public LoginPage(AndroidDriver<AndroidElement> driver) 
	public LoginPage(AppiumDriver<?> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//driver.findElementById("com.androidsample.generalstore:id/nameField")
	@AndroidFindBy(accessibility="test-Username")
	public WebElement userField;
	//driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
	@AndroidFindBy(accessibility="test-Password")
	public WebElement passwordField;
	@AndroidFindBy(accessibility="test-LOGIN")
	public WebElement loginBtn;
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
	public WebElement errMessageElement;
	
	public boolean isDisplayed() {
        return loginBtn.isDisplayed();
    }
    
    public void clickLogin() {
    	loginBtn.click();
    }
    /*public void hideKeyboardIfVisible() {
        if (keyboard != null) {
        driver.hideKeyboard();
            driver.pressKeyCode(AndroidKeyCode.KEYCODE_ESCAPE);
        }
    }*/
    public void login (String uname, String password) {
        //hideKeyboardIfVisible();
    	System.out.println(uname);
        typeName(uname);
        System.out.println(password);
        typePassword(password);
        clickLogin();
    }
    public void typeName(String uname) {
    	userField.sendKeys(uname);
    }
    public void typePassword(String password) {
    	passwordField.sendKeys(password);
    }
    public String errMessage () {
        //hideKeyboardIfVisible();
    	return errMessageElement.getText();
    }
    
	/*
	 * 
    @Value("${login.btn}")
    private String loginBtn;

    @Value("${login.id}")
    private String loginId;

    @Value("${login.password}")
    private String loginPassword;

    @Value("${login.errorMessage}")
    private String errorMessage;

    @Value("${login.view}")
    private String loginView;


    public void enterLoinId(String id){
        appDriverUtil.findByXpath(loginId).sendKeys(id);
    }

    public void enterLoinPassword(String id){
        appDriverUtil.findByXpath(loginPassword).sendKeys(id);
    }

    public void clickLoginButton(){
        appDriverUtil.findByXpath(loginBtn).click();
    }

    public boolean isErrorMessage() {
        return appDriverUtil.waitForElementToAppear(errorMessage);
    }

    public String getErrorMessage() {
       return appDriverUtil.findByXpath(errorMessage).getText();
    }
	 * */
}
