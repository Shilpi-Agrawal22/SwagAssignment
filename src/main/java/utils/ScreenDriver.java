package utils;

import config.ReadPropertyFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * Author
 * Vani Goyal, 2020
 */

public class ScreenDriver {
    public static AppiumDriver driver;
    public static DesiredCapabilities cap;
    static ReadPropertyFile rp = new ReadPropertyFile();

    static String serverURL = rp.readProp("Appium_Server_URL");
    static String ANDROID_DEVICE_NAME = rp.readProp("androidDeviceName");
    static String ANDROID_PLATFORM_NAME = rp.readProp("androidPlatformName");
    static String AUTOMATION_NAME = rp.readProp("automationName");
    static String APP_PACKAGE = rp.readProp("packageName");
    static String APP_ACTIVITY = rp.readProp("activityName");
    static String ANDROID_PLATFORM_VERSION = rp.readProp("androidPlatformVersion");
    static String ANDROID_UDID = rp.readProp("androidUdid");
    static String androidAppPath = System.getProperty("user.dir") + rp.readProp("androidAppPath");

    static String IOS_DEVICE_NAME = rp.readProp("iosDeviceName");
    static String IOS_PLATFORM_NAME = rp.readProp("iosPlatformName");
    static String IOS_PLATFORM_VERSION = rp.readProp("iosPlatformVersion");
    static String IOS_UDID = rp.readProp("iosUdid");
    static String iosAppPath = System.getProperty("user.dir") + rp.readProp("iosAppPath");

    /**
     * This method defines mobile capabilities
     */

    public static AppiumDriver androidCapabilities() throws MalformedURLException {
        cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, ANDROID_DEVICE_NAME);
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, ANDROID_PLATFORM_NAME);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, ANDROID_PLATFORM_VERSION);
        cap.setCapability(MobileCapabilityType.UDID, ANDROID_UDID);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE);
        cap.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, APP_ACTIVITY);
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "2000");
        cap.setCapability(MobileCapabilityType.APP, androidAppPath);
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180000);
        cap.setCapability(MobileCapabilityType.NO_RESET, true);


        cap.setCapability("autoGrantPermissions", true);

        driver = new AndroidDriver(new URL(serverURL), cap);
        return driver;

        
        
    }

    public static AppiumDriver iOSCapabilities() throws MalformedURLException {
        cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, IOS_DEVICE_NAME);
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, IOS_PLATFORM_NAME);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, IOS_PLATFORM_VERSION);
        cap.setCapability(MobileCapabilityType.UDID, IOS_UDID);
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "2000");
        cap.setCapability(MobileCapabilityType.APP, iosAppPath);
        cap.setCapability(MobileCapabilityType.NO_RESET, true);

        cap.setCapability("autoGrantPermissions", true);

        driver = new IOSDriver(new URL(serverURL), cap);
        return driver;
    }
}
