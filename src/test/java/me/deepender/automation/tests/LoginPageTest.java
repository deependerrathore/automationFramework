package me.deepender.automation.tests;

import me.deepender.automation.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class LoginPageTest extends BaseTest {

    private LoginPageTest() {

    }

    @Test
    public void test1() {
        Driver.initDriver();
        Driver.getDriver().findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
    }

}
