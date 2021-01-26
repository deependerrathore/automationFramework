package me.deepender.automation.tests;

import me.deepender.automation.constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
