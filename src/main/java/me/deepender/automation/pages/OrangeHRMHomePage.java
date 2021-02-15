package me.deepender.automation.pages;

import me.deepender.automation.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMHomePage extends BasePage {

    private static By welcomeLink = By.xpath("//a[@id='welcome']");
    private static By logoutLink = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickWelcome() {
        click(welcomeLink, WaitStrategy.CLICKABLE, "Welcome link");
        return this;
    }

    public OrangeHRMLoginPage clickLogout() {
        click(logoutLink, WaitStrategy.CLICKABLE, "Logout button");
        return new OrangeHRMLoginPage();
//        wait.until(d->d.findElement(logout_link).isEnabled());
    }

}
