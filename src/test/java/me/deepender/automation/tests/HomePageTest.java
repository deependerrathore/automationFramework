package me.deepender.automation.tests;

import me.deepender.automation.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class HomePageTest extends BaseTest {

    private HomePageTest() {

    }

    @Test
    public void test2() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("DevOps", Keys.ENTER);
    }

}
