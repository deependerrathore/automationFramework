package me.deepender.automation.utils;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

public class ReadPropertyFile {
    private ReadPropertyFile() {

    }

    public static String getValue(String key) throws Exception {
        String value = "";
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
        properties.load(file);
        value = properties.getProperty(key);
        if (Objects.isNull(value)) {
            throw new Exception("Property name " + key + " is not valid. Please check the config.properties");
        }
        return value;
    }
}
