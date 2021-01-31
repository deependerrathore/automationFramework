package me.deepender.automation.driver;

import me.deepender.automation.constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class Driver {

    private static WebDriver driver;
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

    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
        if (Objects.isNull(getDriver())) {
            driver = new ChromeDriver();
            setDriver(driver);
        }
        getDriver().get("https://www.google.com");
    }

    public static void quitDriver() {
        if (Objects.nonNull(getDriver())) {
            getDriver().quit();
            unloadDriver();
        }
    }
}
