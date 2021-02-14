package me.deepender.automation.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {
    private ExtentReport() {

    }

    private static ExtentReports extentReports;

    public static void intiReport() {
        if (Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("index.html");
            extentReports.attachReporter(extentSparkReporter);
            extentSparkReporter.config().setTheme(Theme.STANDARD);
            extentSparkReporter.config().setDocumentTitle("Automation Framework Report");
            extentSparkReporter.config().setReportName("Framework Report");
        }
    }

    public static void flushReport() throws IOException {
        if (Objects.nonNull(extentReports)) {
            extentReports.flush();
            ExtentReportManager.unloadExtentTest();
        }
        Desktop.getDesktop().browse(new File("index.html").toURI());
    }

    public static void createTet(String testName) {
        ExtentReportManager.setExtentTest(extentReports.createTest(testName));
    }
}
