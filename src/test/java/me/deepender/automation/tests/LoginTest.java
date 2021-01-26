package me.deepender.automation.tests;

import me.deepender.automation.constants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

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

    @Test
    public void test1() {
        driver.findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
    }

    @Test
    public void test2() {
        driver.findElement(By.name("q")).sendKeys("DevOps", Keys.ENTER);
    }
}
