package me.deepender.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

public class ReadPropertyFile {
    private ReadPropertyFile() {

    }

    private static Properties properties = new Properties();
    private static final HashMap<String, String> CONFIG_MAP = new HashMap<>();

    static {
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
            properties.load(file);
            for (Object key :
                    properties.keySet()) {
                CONFIG_MAP.put(String.valueOf(key), String.valueOf(properties.getProperty((String) key)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Execution will be faster if the key will get use multiple times in framework say 100 key value will be called 500times in framework
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String getValueFromMap(String key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(CONFIG_MAP.get(key))) {
            throw new Exception("Property name " + key + " is not valid. Please check the config.properties");
        }
        return CONFIG_MAP.get(key);
    }

    /**
     * Can be used if we have few key value which is not frequently used in framework
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String getValue(String key) throws Exception {
        if (Objects.isNull(properties.getProperty(key)) || Objects.isNull(key)) {
            throw new Exception("Property name " + key + " is not valid. Please check the config.properties");
        }
        return properties.getProperty(key);
    }
}
