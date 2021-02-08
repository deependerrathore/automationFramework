package me.deepender.automation.factories;

import me.deepender.automation.constants.FrameworkConstants;
import me.deepender.automation.driver.DriverManager;
import me.deepender.automation.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitFactory {
    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {
        WebElement webElement = null;
        if (waitStrategy == WaitStrategy.CLICKABLE) {
            webElement = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitlyWait())
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitStrategy == WaitStrategy.PRESENT) {
            webElement = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitlyWait())
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            webElement = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitlyWait())
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.NONE) {
            webElement = DriverManager.getDriver().findElement(by);
        }
        return webElement;
    }
}
