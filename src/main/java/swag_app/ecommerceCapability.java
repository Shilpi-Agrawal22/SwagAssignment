package swag_app;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ecommerceCapability {
	public static AndroidDriver<AndroidElement> Capabilities(String appName) throws MalformedURLException, IOException {
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\swag_app\\global.properties");
		Properties p=new Properties();
		p.load(fis);
		
		;
	File f=new File("src");
	//File fs= new File(f, "General-Store.apk");
	File fs= new File(f, (String) p.get(appName));
	System.out.println(fs.getAbsolutePath());
	DesiredCapabilities cap= new DesiredCapabilities();
	String device= (String) p.get(appName);
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
	//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
	cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
	cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.swaglabsmobileapp");
	cap.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.swaglabsmobileapp.*");
	cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
	AndroidDriver<AndroidElement> driver= new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	return driver;
}
}

