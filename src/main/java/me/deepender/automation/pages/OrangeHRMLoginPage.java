package me.deepender.automation.pages;

import me.deepender.automation.driver.DriverManager;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage {
    private static By textbox_username = By.xpath("//input[@id='txtUsername']");
    private static By textbox_password = By.xpath("//input[@id='txtPassword' and @type='password']");
    private static By login_button = By.xpath("//input[@id='btnLogin' and @type='submit']");

    public OrangeHRMLoginPage setUsername(String username) {
        DriverManager.getDriver().findElement(textbox_username).sendKeys(username);
        return this;
    }


    public OrangeHRMLoginPage setPassword(String password) {
        DriverManager.getDriver().findElement(textbox_password).sendKeys(password);
        return this;
    }


    public OrangeHRMHomePage clickLoginBtn() {
        DriverManager.getDriver().findElement(login_button).click();
        return new OrangeHRMHomePage();
    }
}
