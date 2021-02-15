package me.deepender.automation.pages;

import me.deepender.automation.driver.DriverManager;
import me.deepender.automation.enums.WaitStrategy;
import me.deepender.automation.factories.ExplicitWaitFactory;
import me.deepender.automation.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected BasePage() {

    }

    protected void click(By by, WaitStrategy waitStrategy, String elementDescription) {
        WebElement webElement = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        webElement.click();
        ExtentLogger.pass(elementDescription + " is clicked");
    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementDescription) {
        WebElement webElement = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        webElement.sendKeys(value);
        ExtentLogger.pass("'" +value+"'" + " is entered successfully in " + elementDescription);
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }


}
