package me.deepender.automation.tests;

import me.deepender.automation.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class HomePageTest extends BaseTest {

    private HomePageTest() {

    }

    @Test
    public void test2() {
        Driver.driver.findElement(By.name("q")).sendKeys("DevOps", Keys.ENTER);
    }
}
