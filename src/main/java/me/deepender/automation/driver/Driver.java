package me.deepender.automation.driver;

import me.deepender.automation.constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public final class Driver {

    private Driver() {

    }

    private static WebDriver driver;

    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
        if (Objects.isNull(DriverManager.getDriver())) {
            driver = new ChromeDriver();
            DriverManager.setDriver(driver);
        }
        DriverManager.getDriver().get("https://www.google.com");
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unloadDriver();
        }
    }
}
