package me.deepender.automation.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
    private ExtentManager() {

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
