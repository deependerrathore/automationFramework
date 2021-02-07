package me.deepender.automation.tests;

import me.deepender.automation.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class HomePageTest extends BaseTest {

    private HomePageTest() {

    }

    /**
     * Validate whether the title is containing Google Search or google search
     * Validate whether the title is not null and the lenght of title is greater than 15 and less than 100
     * Check for the links in the pages --> DevOps - Youtube
     * number of links displayed is exactly 19
     */
    @Test
    public void test2() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("DevOps", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();

        assertThat(title)
                .as("Title is not matching").containsIgnoringCase("Google Search")
                .isNotNull()
                .hasSizeBetween(15, 100)
                .matches("\\w.*" + " Google Search");

        List<WebElement> elementList = DriverManager.getDriver().findElements(By.xpath("//h3/span"));

        assertThat(elementList)
                .hasSize(19)
                .extracting(e -> e.getText())
                .contains("DevOps - Wikipedia");
    }

}
