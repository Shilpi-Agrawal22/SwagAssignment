package listeners;

import base.TestBase;
import io.qameta.allure.Attachment;

//import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestAllureScreenshotListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("TEST FAILED:" + iTestResult.getName());
		System.out.println("TEST FAILED REASON:" + iTestResult.getThrowable().getMessage());
//		saveScreenshotPNG(TestBase.getDriver());
		saveTextLog(iTestResult.getMethod().getConstructorOrMethod().getName());
	}

	/*
	 * @Attachment(value = "Screenshot", type = "image/png") public byte[]
	 * saveScreenshotPNG(WebDriver driver) { return ((TakesScreenshot)
	 * driver).getScreenshotAs(OutputType.BYTES); }*/
	
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("TEST PASSED:" + iTestResult.getName());
	} 

}