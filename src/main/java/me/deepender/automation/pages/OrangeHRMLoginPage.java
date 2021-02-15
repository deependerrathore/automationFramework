package me.deepender.automation.pages;

import me.deepender.automation.enums.WaitStrategy;
import me.deepender.automation.reports.ExtentLogger;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage {
    private static By textboxUsername = By.xpath("//input[@id='txtUsername']");
    private static By textboxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
    private static By loginButton = By.xpath("//input[@id='btnLogin' and @type='submit']");

    public OrangeHRMLoginPage setUsername(String username) {
        sendKeys(textboxUsername, username, WaitStrategy.PRESENT);
        ExtentLogger.pass("Entered the username");
        return this;
    }


    public OrangeHRMLoginPage setPassword(String password) {
        sendKeys(textboxPassword, password, WaitStrategy.PRESENT);
        ExtentLogger.pass("Entered the password");
        return this;
    }


    public OrangeHRMHomePage clickLoginBtn() {
        click(loginButton, WaitStrategy.CLICKABLE);
        ExtentLogger.pass("Clicked the login button");
        return new OrangeHRMHomePage();
    }

    public String getTitle() {
        return getPageTitle();
    }
}
