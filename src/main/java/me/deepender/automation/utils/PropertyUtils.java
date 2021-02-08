package me.deepender.automation.utils;

import me.deepender.automation.constants.FrameworkConstants;
import me.deepender.automation.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

public class PropertyUtils {
    private PropertyUtils() {

    }

    private static Properties properties = new Properties();
    private static final HashMap<String, String> CONFIG_MAP = new HashMap<>();

    static {
        try {
            FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath());
            properties.load(file);
            properties.entrySet().forEach(entry -> CONFIG_MAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
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
    public static String getValueFromMap(ConfigProperties key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(CONFIG_MAP.get(key))) {
            throw new Exception("Property name " + key + " is not valid. Please check the config.properties");
        }
        return CONFIG_MAP.get(key.name().toLowerCase());
    }

    /**
     * Can be used if we have few key value which is not frequently used in framework
     * And we think that HashTable to HashMap conversion will take time rather than reading the property directly
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
