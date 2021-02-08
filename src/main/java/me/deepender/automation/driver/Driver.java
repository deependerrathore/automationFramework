package me.deepender.automation.driver;

import me.deepender.automation.constants.FrameworkConstants;
import me.deepender.automation.enums.ConfigProperties;
import me.deepender.automation.utils.PropertyUtils;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public final class Driver {

    private Driver() {

    }

    public static void initDriver() throws Exception {
        if (Objects.isNull(DriverManager.getDriver())) {
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
            DriverManager.setDriver(new ChromeDriver());
            DriverManager.getDriver().get(PropertyUtils.getValueFromMap(ConfigProperties.URL));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unloadDriver();
        }
    }
}
