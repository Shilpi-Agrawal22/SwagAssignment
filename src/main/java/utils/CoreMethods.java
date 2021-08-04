package utils;

//import com.sun.javafx.scene.traversal.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;



public class CoreMethods {
    public static final Logger LOGGER = Logger.getLogger(CoreMethods.class.getName());
    public static AppiumDriver driver;

    WaitUtils waitUtils = new WaitUtils();
    private boolean flag = false;

    public CoreMethods(AppiumDriver driver) {
        this.driver = driver;
    }



    @Step("Verify if element : {0} is Displayed....")
    public boolean isDisplayed(WebElement element) {
        LOGGER.info("************** Verify if element :" + element + " is displayed **************");
        waitUtils.waitForElementToBeVisible(element, driver);
        if (element.isDisplayed()) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }



    @Step("Tapping the element : {0} ....")
    public void tap(WebElement element) {
        LOGGER.info("************** Tapping on element: " + element + " **************");
        waitUtils.waitForElementToBeVisible(element, driver);
        if (element.isDisplayed()) {
            waitUtils.waitForElementToBeClickable(element, driver);
            element.click();
        }
    }



    public void tapPhone(WebElement element) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(tapOptions().withElement(element(element))).perform().release();
    }



    @Step("Get Text of element : {0} ....")
    public String getText(WebElement element) {
        LOGGER.info("************** Get Text of element: " + element + " **************");
        String text = null;
        waitUtils.waitForElementToBeVisible(element, driver);
        if (element.isDisplayed()) {
            text = element.getText();
        }
        return text;
    }



    @Step("Send Text : {1} for element : {0}")
    public void sendKeys(WebElement element, String val) {
        LOGGER.info("************** Sendkeys on element: " + element + " **************");
        if (element.isDisplayed())
            waitUtils.waitForElementToBeClickable(element, driver);
        {
            element.sendKeys(val);
        }
    }



    @Step("Verify Actual Text : {1}")
    public boolean verifyText(WebElement element, String message) {
        LOGGER.info("************** Verifying text **************");
        String actualErr = getText(element);
        return actualErr.trim().equalsIgnoreCase(message.trim());
    }

 

    @Step("Verify Actual (contains) Text : {1}")
    public boolean verifyContainsText(WebElement element, String message) {
        LOGGER.info("************** Verifying text **************");
        String actualErr = getText(element);
        return actualErr.contains(message);
    }

    public void clear(WebElement element) {
        if (element.isDisplayed())
            waitUtils.waitForElementToBeClickable(element, driver);
        {
            element.clear();
        }
    }


    @Step("Wait for element : {0} to disappear....")
    public void isNotDisplayed(List<WebElement> element) {
        LOGGER.info("************** Verify element:" + element + " is not displayed **************");
        waitUtils.staticWait(2000);
        while (element.size() != 0) {
            waitUtils.staticWait(2000);
        }
    }



    @Step("Scrolling on App from Down to Up....")
    public boolean scroll() {
        LOGGER.info("************** Scrolling from Down to Up **************");
        try {
            Dimension size = driver.manage().window().getSize();
            int x = (int) (size.getWidth() * 0.5);
            int y0 = (int) (size.getHeight() * 0.8);
            int y1 = (int) (size.getHeight() * 0.2);
            MultiTouchAction touch = new MultiTouchAction(driver);
            touch.add(new TouchAction<>(driver)
                    .press(point(x, y0))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(point(x, y1)).release())
                    .perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }



    @Step("Get 2 Dates days difference current date and date: {0} ....")
    public long getDaysDiff(Date date1) {
        LOGGER.info("************** Get 2 Dates days difference **************");
        Date date = new Date();
        return ChronoUnit.DAYS.between(date1.toInstant(), date.toInstant());
    }


    @Step("Verify Actual (contains) Text in a list : {1}")
    public boolean verifyContainsText(List<WebElement> element, String message) {
        LOGGER.info("************** Verifying text **************");
        boolean textPresent = false;
        for (int i = 0; i < element.size(); i++) {
            String actualErr = getText(element.get(i));
            if (actualErr.contains(message)) {
                textPresent = true;
            } else {
                textPresent = false;
            }
        }
        return textPresent;
    }


    @Step("Hide keyboard")
    public void hideKeyboard() {
        driver.hideKeyboard();
    }



    @Step("Scrolls till element is visible")
    public void scrollToTextAndClick(String text) {
        WebElement el = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector()" +
                        ".textContains(\"" + text + "\").instance(0))"));
        el.click();
    }



    /*@Step("Swipe right to left")
    public void swipe(WebElement el, Direction dir) {
        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 500; // ms

        Dimension dims = driver.manage().window().getSize();
        Rectangle rect = el.getRect();

        // check element overlaps screen
        if (rect.x >= dims.width || rect.x + rect.width <= 0
                || rect.y >= dims.height || rect.y + rect.height <= 0) {
            throw new IllegalArgumentException("swipeElementIOS(): Element outside screen");
        }

        // init borders per your app screen
        // or make them configurable with function variables
        int leftBorder, rightBorder, upBorder, downBorder;
        leftBorder = 0;
        rightBorder = 0;
        upBorder = 0;
        downBorder = 0;

        // find rect that overlap screen
        if (rect.x < 0) {
            rect.width = rect.width + rect.x;
            rect.x = 0;
        }
        if (rect.y < 0) {
            rect.height = rect.height + rect.y;
            rect.y = 0;
        }
        if (rect.width > dims.width)
            rect.width = dims.width;
        if (rect.height > dims.height)
            rect.height = dims.height;

        PointOption pointOptionStart, pointOptionEnd;
        switch (dir) {
            case DOWN: // from up to down
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + upBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - downBorder);
                break;
            case UP: // from down to up
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - downBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + upBorder);
                break;
            case LEFT: // from right to left
                pointOptionStart = PointOption.point(rect.x + rect.width - rightBorder,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + leftBorder,
                        rect.y + rect.height / 2);
                break;
            case RIGHT: // from left to right
                pointOptionStart = PointOption.point(rect.x + leftBorder,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + rect.width - rightBorder,
                        rect.y + rect.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeElementIOS(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeElementIOS(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }
*/

}