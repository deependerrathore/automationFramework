package me.deepender.automation.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.deepender.automation.constants.FrameworkConstants;
import me.deepender.automation.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

public class JsonUtils {
    private JsonUtils() {

    }

    private static HashMap<String, String> CONFIG_MAP = new HashMap<>();

    static {
        try {
            FileInputStream file = new FileInputStream(FrameworkConstants.getJsonConfigFilePath());
            CONFIG_MAP = new ObjectMapper().readValue(file, new TypeReference<HashMap<String, String>>() {
            });
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
        if (Objects.isNull(key) || Objects.isNull(CONFIG_MAP.get(key.name().toLowerCase()))) {
            throw new Exception("Property name " + key + " is not valid. Please check the config.properties");
        }
        return CONFIG_MAP.get(key.name().toLowerCase());
    }
}
