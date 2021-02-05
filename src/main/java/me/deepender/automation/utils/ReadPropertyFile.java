package me.deepender.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ReadPropertyFile {
    private ReadPropertyFile() {

    }

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
            properties.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) throws Exception {
        if (Objects.isNull(properties.getProperty(key)) || Objects.isNull(key)) {
            throw new Exception("Property name " + key + " is not valid. Please check the config.properties");
        }
        return properties.getProperty(key);
    }
}
