package me.deepender.automation.tests;

import me.deepender.automation.driver.Driver;
import me.deepender.automation.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest {

    protected BaseTest(){

    }

    @BeforeSuite
    public void beforeSuite(){
        ExtentReport.intiReport();
    }

    @AfterSuite
    public void afterSuite() throws IOException {
        ExtentReport.flushReport();
    }

    @BeforeMethod
    protected void setUp() throws Exception {
        Driver.initDriver();
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }

}
