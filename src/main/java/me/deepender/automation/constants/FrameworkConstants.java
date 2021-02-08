package me.deepender.automation.constants;

//Declaring class as final so that no one can extend this
public final class FrameworkConstants {

    //As all of the methods will be static we don't want to initialize this class
    private FrameworkConstants() {

    }

    private static final String RESOURCE_PATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CHROME_DRIVER_PATH = RESOURCE_PATH + "/driverBinary/chromedriver";
    private static final String CONFIG_FILE_PATH = RESOURCE_PATH + "/config/config.properties";

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


}
