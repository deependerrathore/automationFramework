package me.deepender.automation.constants;

//Declaring class as final so that no one can extend this
public final class FrameworkConstants {

    //As all of the methods will be static we don't want to initialize this class
    private FrameworkConstants(){

    }

    private static final String CHROME_DRIVER_PATH = System.getProperty("user.dir")+"/src/test/resources/driverBinary/chromedriver";

    public static String getChromeDriverPath() {
        return CHROME_DRIVER_PATH;
    }

}
