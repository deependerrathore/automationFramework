package me.deepender.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{
    @Test
    public void test2() {
        driver.findElement(By.name("q")).sendKeys("DevOps", Keys.ENTER);
    }
}
