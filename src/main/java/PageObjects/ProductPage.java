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
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"PRODUCTS\"]")
	public WebElement productPageHeader;
	//driver.findElementsByXPath("(//android.widget.TextView[@content-desc=\"test-Item title\"])").size();
	@AndroidFindBy(xpath="(//android.widget.TextView[@content-desc=\"test-Item title\"])")
	public List<WebElement> productElements;
	//driver.findElementsByXPath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]");
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]")
	public List<WebElement> productAddToCartElements;
	//driver.findElementsByXPath("android.widget.TextView[@content-desc=\"test-Price\"]")
	@AndroidFindBy(xpath="android.widget.TextView[@content-desc=\"test-Price\"]")
	public List<WebElement> productPriceElements;
	//driver.findElementByXPath("//android.view.ViewGroup[@content-desc='test-Cart']")
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='test-Cart']")
	public WebElement productCartEle;
	//driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Description\"]")
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-Description\"]")
	public WebElement productTestDescriptionEle;
	//@AndroidFindAll(priority=, value = { @AndroidBy })
	//public WebElement productPageElement;
	public void verifySuccessfulLogin () {
        System.out.println("implement Login successful");
        Assert.assertTrue(productPageHeader.isDisplayed());
    }
	/* @Autowired
	    private ContextData contextData;

	    @Value("${product-cartItem}")
	    private String productInCart;

	    @Value("${product-itemList}")
	    private String productItemList;

	    @Value("${product-price}")
	    private String productPrice;

	    @Value("${product-title}")
	    private String productTitle;

	    @Value("${product-addToCart}")
	    private String productAddToCart;

	    @Value("${product-remove}")
	    private String productRemove;




	    private  WebElement addProductEle(WebElement parentEle){
	        return   parentEle.findElement(By.xpath(productAddToCart));
	    }

	    private  WebElement removeProductEle(WebElement parentEle){
	        return   parentEle.findElement(By.xpath(productRemove));
	    }

	    private WebElement getProductPriceEle(WebElement parentEle){
	       return parentEle.findElement(By.xpath(productPrice));
	    }

	    private WebElement getProductTitleEle(WebElement parentEle){
	        return parentEle.findElement(By.xpath(productTitle));
	    }

	    private List<WebElement> getProductListEle(){
	        return appDriverUtil.findElementListByXpath(productItemList);
	    }


	    public void saveFirstProductPrice(String conVar) {
	       WebElement webElement = getProductListEle().get(0);
	       String prodPrice = getProductPriceEle(webElement).getText();
	       contextData.setContextValue(conVar,prodPrice);
	    }

	    public void saveFirstProductTitle(String conVar) {
	        WebElement webElement = getProductListEle().get(0);
	        String prodTitle = getProductTitleEle(webElement).getText();
	        contextData.setContextValue(conVar,prodTitle);
	    }

	    public void selectFirstItem() {
	        WebElement webElement = getProductListEle().get(0);
	        addProductEle(webElement).click();
	    }

	    public void removeProductFromCart() {
	        WebElement webElement = getProductListEle().get(0);
	        removeProductEle(webElement).click();
	    }

	    public void waitForProductView() {
	        Assertions.assertThat(appDriverUtil.waitForElementToAppear(productInCart)).isEqualTo(true);
	    }

	    public void cartHaveOneProduct() {
	       Assertions.assertThat(appDriverUtil.findByXpath(productInCart).findElement(By.xpath("//android.widget.TextView")).getText()).isEqualTo("1");
	    }

	    public void cartHaveNoProduct() {
	        Assertions.assertThat(appDriverUtil.findByXpath(productInCart).findElements(By.xpath("//android.widget.TextView")).size()).isEqualTo(0);
	    }*/
	

	



	

}
