package me.deepender.automation.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager() {

    }

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

    public static void unloadDriver() {
        webDriverThreadLocal.remove();
    }

    public static void setDriver(WebDriver driver) {
        webDriverThreadLocal.set(driver);
    }
}
