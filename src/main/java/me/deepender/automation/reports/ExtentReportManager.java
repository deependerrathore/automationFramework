package me.deepender.automation.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {
    private ExtentReportManager() {

    }

    private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    public static ExtentTest getExtentTest() {
        return extentTestThreadLocal.get();
    }

    public static void setExtentTest(ExtentTest test) {
        extentTestThreadLocal.set(test);
    }

    public static void unloadExtentTest() {
        extentTestThreadLocal.remove();
    }
}
