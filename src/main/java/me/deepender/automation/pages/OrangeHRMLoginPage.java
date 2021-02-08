package me.deepender.automation.pages;

import me.deepender.automation.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage {
    private static By textboxUsername = By.xpath("//input[@id='txtUsername']");
    private static By textboxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
    private static By loginButton = By.xpath("//input[@id='btnLogin' and @type='submit']");

    public OrangeHRMLoginPage setUsername(String username) {
        sendKeys(textboxUsername, username, WaitStrategy.PRESENT);
        return this;
    }


    public OrangeHRMLoginPage setPassword(String password) {
        sendKeys(textboxPassword, password, WaitStrategy.PRESENT);
        return this;
    }


    public OrangeHRMHomePage clickLoginBtn() {
        click(loginButton, WaitStrategy.CLICKABLE);
        return new OrangeHRMHomePage();
    }

    public String getTitle() {
        return getPageTitle();
    }
}
