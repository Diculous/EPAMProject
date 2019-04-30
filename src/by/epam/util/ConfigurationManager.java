package by.epam.util;

import java.util.ResourceBundle;

public class ConfigurationManager {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("by/epam/ConnectionConfig");
    private static final ResourceBundle resourceBundleSQL = ResourceBundle.getBundle("by/epam/SQLConfig");

    public ConfigurationManager() {
    }
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
    public static String getPropertySQL(String key) {
        return resourceBundleSQL.getString(key);
    }
}