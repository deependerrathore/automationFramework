package me.deepender.automation.tests;

import me.deepender.automation.pages.OrangeHRMHomePage;
import me.deepender.automation.pages.OrangeHRMLoginPage;
import org.testng.annotations.Test;

public final class OrangeHRMTests extends BaseTest{
    private OrangeHRMTests() {

    }

    @Test
    public void loginLogout(){
        OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();
        OrangeHRMHomePage ohhp = ohlp.setUsername("Admin").setPassword("admin123").clickLoginBtn();
        ohhp.logout();
    }
}

