package me.deepender.automation.tests;

import me.deepender.automation.constants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void test1(){
        System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
        driver.quit();
    }
    @Test
    public void test2(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("DevOps", Keys.ENTER);
        driver.quit();
    }
}
