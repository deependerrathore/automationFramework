package me.deepender.automation.constants;

import me.deepender.automation.enums.ConfigProperties;
import me.deepender.automation.utils.PropertyUtils;

//Declaring class as final so that no one can extend this
public final class FrameworkConstants {

    //As all of the methods will be static we don't want to initialize this class
    private FrameworkConstants() {

    }

    private static final String RESOURCE_PATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CHROME_DRIVER_PATH = RESOURCE_PATH + "/driverBinary/chromedriver";
    private static final String CONFIG_FILE_PATH = RESOURCE_PATH + "/config/config.properties";
    private static final String JSON_CONFIG_FILE_PATH = RESOURCE_PATH + "/json/config.json";
    private static final String EXTENT_REPORT_FOLDER_PATH = System.getProperty("user.dir") + "/extent-test-output";
    private static final String EXCEL_PATH = RESOURCE_PATH + "/excel/runner.xlsx";

    private static String extentReportFilePath = "";
    private static final int EXPLICITLY_WAIT = 10;


    public static String getChromeDriverPath() {
        return CHROME_DRIVER_PATH;
    }

    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }

    public static int getExplicitlyWait() {
        return EXPLICITLY_WAIT;
    }

    public static String getJsonConfigFilePath() {
        return JSON_CONFIG_FILE_PATH;
    }

    private static String createExtentReportPath() throws Exception {
        if (PropertyUtils.getValueFromMap(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            return EXTENT_REPORT_FOLDER_PATH + "/" + System.currentTimeMillis() + "/index.html";
        } else {
            return EXTENT_REPORT_FOLDER_PATH + "/index.html";
        }
    }

    public static String getExtentReportFilePath() throws Exception {
        if (extentReportFilePath.isEmpty()){
            return extentReportFilePath = createExtentReportPath();
        }
        return extentReportFilePath;
    }

    public static String getExcelPath() {
        return EXCEL_PATH;
    }
}
