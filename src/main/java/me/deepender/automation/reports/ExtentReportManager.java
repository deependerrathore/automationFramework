package me.deepender.automation.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {
    private ExtentReportManager() {

    }

    private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    static ExtentTest getExtentTest() {
        return extentTestThreadLocal.get();
    }

    static void setExtentTest(ExtentTest test) {
        extentTestThreadLocal.set(test);
    }

    static void unloadExtentTest() {
        extentTestThreadLocal.remove();
    }
}
