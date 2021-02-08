package me.deepender.automation.pages;

import me.deepender.automation.driver.DriverManager;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage {
    private static By textboxUsername = By.xpath("//input[@id='txtUsername']");
    private static By textboxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
    private static By loginButton = By.xpath("//input[@id='btnLogin' and @type='submit']");

    public OrangeHRMLoginPage setUsername(String username) {
        DriverManager.getDriver().findElement(textboxUsername).sendKeys(username);
        return this;
    }


    public OrangeHRMLoginPage setPassword(String password) {
        DriverManager.getDriver().findElement(textboxPassword).sendKeys(password);
        return this;
    }


    public OrangeHRMHomePage clickLoginBtn() {
        DriverManager.getDriver().findElement(loginButton).click();
        return new OrangeHRMHomePage();
    }

    public String getTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
