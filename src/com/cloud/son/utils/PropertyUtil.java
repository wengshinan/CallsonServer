package com.cloud.son.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by wengshinan on 2015/6/26.
 */
public class PropertyUtil {
    public static final String KEY_DB_URL = "db_url";
    public static final String KEY_DB_USER = "db_user";
    public static final String KEY_DB_PASSWORD = "db_password";
    public static final String KEY_DB_DRIVER = "db_driver";
    public static final String KEY_SERVER_PORT = "server_port";
    public static final String KEY_DATA_TYPE = "data_type";
    public static final String KEY_DATA_LONGEST_LENGTH = "data_longest_length";
    private static final String PROPERTY_FILE = "default.properties";
    private Properties properties = null;

    private PropertyUtil() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(PROPERTY_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return PropertyHolder.pUtil.getProp(key);
    }

    private String getProp(String key) {
        return properties.getProperty(key);
    }

    private static class PropertyHolder {
        private static final PropertyUtil pUtil = new PropertyUtil();
    }
}
