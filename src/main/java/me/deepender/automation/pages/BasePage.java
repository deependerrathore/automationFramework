package me.deepender.automation.pages;

import me.deepender.automation.driver.DriverManager;
import me.deepender.automation.enums.WaitStrategy;
import me.deepender.automation.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected BasePage() {

    }

    protected void click(By by, WaitStrategy waitStrategy) {
        WebElement webElement = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        webElement.click();
    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy) {
        WebElement webElement = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        webElement.sendKeys(value);
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }


}
