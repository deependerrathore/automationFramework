package me.deepender.automation.pages;

import me.deepender.automation.driver.DriverManager;
import org.openqa.selenium.By;

public final class OrangeHRMHomePage {

    private static By profile_link = By.xpath("//a[@id='welcome']");
    private static By logout_link = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage logout(){
        DriverManager.getDriver().findElement(profile_link).click();
        DriverManager.getDriver().findElement(logout_link).click();
        return this;
    }

}
