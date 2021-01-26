package me.deepender.automation.driver;

import me.deepender.automation.constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class Driver {

    public static WebDriver driver;

    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
        if (Objects.isNull(driver)) {
            driver = new ChromeDriver();
        }
        driver.get("https://www.google.com");
    }

    public static void quitDriver() {
        if (Objects.nonNull(driver)) {
            driver.quit();
            driver = null;
        }
    }
}
