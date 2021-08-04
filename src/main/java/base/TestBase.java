package base;

import config.ReadPropertyFile;
import utils.ScreenDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.util.logging.Logger;
/**
 * Author
 * Vani Goyal, 2020
 */

public class TestBase {
    public static AppiumDriver driver;
    public static AppiumDriverLocalService service;
    public static SoftAssert softAssert;
    public static final Logger LOGGER = Logger.getLogger(TestBase.class.getName());

    static ReadPropertyFile rp = new ReadPropertyFile();
    static String Platform = rp.readProp("PLATFORM");


    public static void setUpDriver() {
        softAssert = new SoftAssert();
        LOGGER.info("**************  Initializing driver  **************");
        try {
            if (Platform.equals("android"))
            {
                LOGGER.info("********************* Launched in Android Driver *******************");
                driver = ScreenDriver.androidCapabilities();
            }
            else{
                LOGGER.info("********************* Launched in iOS Driver *******************");
                driver = ScreenDriver.iOSCapabilities();
            }
            Thread.sleep(2000);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void tearDownDriver() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (driver != null) {
            driver.quit();
            driver = null;
            LOGGER.info("**************  Closing driver  **************");
        }
    }
    public static AppiumDriver getDriver() {
        return driver;
    }
}
