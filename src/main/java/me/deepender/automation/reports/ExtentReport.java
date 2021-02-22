package me.deepender.automation.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import me.deepender.automation.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {
    private ExtentReport() {

    }

    private static ExtentReports extentReports;

    public static void intiReport() throws Exception {
        if (Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extentReports.attachReporter(extentSparkReporter);
            extentSparkReporter.config().setTheme(Theme.STANDARD);
            extentSparkReporter.config().setDocumentTitle("Automation Framework Report");
            extentSparkReporter.config().setReportName("Framework Report");
        }
    }

    public static void flushReport() throws Exception {
        if (Objects.nonNull(extentReports)) {
            extentReports.flush();
            ExtentManager.unloadExtentTest();
        }
        Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
    }

    public static void createTest(String testName) {
        ExtentManager.setExtentTest(extentReports.createTest(testName));
    }
}
