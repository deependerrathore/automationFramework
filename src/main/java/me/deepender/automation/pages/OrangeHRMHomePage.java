package me.deepender.automation.pages;

import me.deepender.automation.enums.WaitStrategy;
import me.deepender.automation.reports.ExtentLogger;
import org.openqa.selenium.By;

public final class OrangeHRMHomePage extends BasePage {

    private static By welcomeLink = By.xpath("//a[@id='welcome']");
    private static By logoutLink = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickWelcome() {
        click(welcomeLink, WaitStrategy.CLICKABLE);
        ExtentLogger.pass("Clicked the welcome link");
        return this;
    }

    public OrangeHRMLoginPage clickLogout() {
        click(logoutLink, WaitStrategy.CLICKABLE);
        ExtentLogger.pass("Clicked the logout link");
        return new OrangeHRMLoginPage();
//        wait.until(d->d.findElement(logout_link).isEnabled());
    }

}
