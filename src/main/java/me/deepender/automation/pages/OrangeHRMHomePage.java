package me.deepender.automation.pages;

import me.deepender.automation.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class OrangeHRMHomePage {

    private static By welcomeLink = By.xpath("//a[@id='welcome']");
    private static By logoutLink = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickWelcome() {
        DriverManager.getDriver().findElement(welcomeLink).click();
        return this;
    }

    public OrangeHRMLoginPage clickLogout() {
        new WebDriverWait(DriverManager.getDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(logoutLink));
        DriverManager.getDriver().findElement(logoutLink).click();
        return new OrangeHRMLoginPage();
//        wait.until(d->d.findElement(logout_link).isEnabled());
    }

}
