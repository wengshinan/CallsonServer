package com.cloud.son.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by wengshinan on 2015/6/26.
 */
public class PropertyUtil {
    private static PropertyUtil pUtil = null;

    public static final String KEY_DB_URL = "db_url";
    public static final String KEY_DB_USER = "db_user";
    public static final String KEY_DB_PASSWORD = "db_password";
    public static final String KEY_DB_DRIVER = "db_driver";
    public static final String KEY_DATA_TYPE = "data_type";
    public static final String KEY_DATA_LONGEST_LENGTH = "data_longest_length";
    private static final String PROPERTY_FILE = "default.properties";

    private Properties properties = null;

    private PropertyUtil() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(PROPERTY_FILE));
    }

    public static void reloadProperty() throws IOException {
        pUtil = new PropertyUtil();
    }

    private String getProp(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key) throws IOException{
        if (null == pUtil) PropertyUtil.reloadProperty();
        return pUtil.getProp(key);
    }
}
