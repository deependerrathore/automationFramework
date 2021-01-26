package me.deepender.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void test1() {
        driver.findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
    }

    @Test
    public void test2() {
        driver.findElement(By.name("q")).sendKeys("DevOps", Keys.ENTER);
    }
}
