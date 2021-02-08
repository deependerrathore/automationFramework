package me.deepender.automation.tests;

import me.deepender.automation.pages.OrangeHRMLoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public final class OrangeHRMTests extends BaseTest {
    private OrangeHRMTests() {

    }

    @Test
    public void loginLogout() throws InterruptedException {
        String title = new OrangeHRMLoginPage()
                .setUsername("Admin").setPassword("admin123").clickLoginBtn()
                .clickWelcome().clickLogout()
                .getTitle();

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }
}

