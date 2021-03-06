package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitUtils {
    public final int explicitWaitDefault = 30; //15

  
    public void staticWait(final long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (final InterruptedException e) {
        }
    }

   
    public void waitForElementToBeClickable(final WebElement
                                                    element, final WebDriver driver) {
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * To wait for element (By) to be invisible
     *
     * @param driver
     * @param locator
     */
    public void waitForElementToBeInvisible(final By locator,
                                            final WebDriver driver) {
        long s = System.currentTimeMillis();
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * To wait for given element (By) to be present
     *
     * @param driver
     * @param locator
     */
    public void waitForElementToBePresent(final By locator,
                                          final WebDriver driver) {
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * To wait for element to be visible
     *
     * @param driver
     * @param element
     */
    public void waitForElementToBeVisible(final WebElement
                                                  element, final WebDriver driver) {
        long s = System.currentTimeMillis();
        new WebDriverWait(driver,
                this.explicitWaitDefault).until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * To wait for elements to be visible
     *
     * @param driver
     * @param element
     */
    public void waitForElementsToBeInvisible(final
                                             WebElement element, final WebDriver driver) {
        final long s = System.currentTimeMillis();
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.invisibilityOf(element)
                );
    }

    /**
     * To wait for element not to remain visible
     *
     * @param driver
     * @param element
     */
    public void waitForElementToBeNotPresent(final By
                                                     element, WebDriver driver) {
        long s = System.currentTimeMillis();
        new WebDriverWait(driver, this.explicitWaitDefault)
                .until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(element)));
    }
}