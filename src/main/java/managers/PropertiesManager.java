package managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private final Properties properties;

    public PropertiesManager() {
        properties = new Properties();
        try {
            // Load the properties from the config.properties file
            FileInputStream fileInputStream = new FileInputStream("src/main/config/config.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception according to your requirements
        }
    }

    /**
     * Get the value of a property by key
     *
     * @param key The key of the property
     * @return The value of the property
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    // You can add more methods if needed, for example, to handle different types of properties

    // Example method to get an integer property
    public int getIntProperty(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

    // Example method to get a boolean property
    public boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }

    // Example method to get a double property
    public double getDoubleProperty(String key) {
        return Double.parseDouble(properties.getProperty(key));
    }

    // Add more methods based on your requirements

//    public static void main(String[] args) {
//        // Example usage of the PropertiesManager class
//        PropertiesManager propertiesManager = new PropertiesManager();
//
//        // Fetch a property by key
//        String appiumServerUrl = propertiesManager.getProperty("appium.server.url");
//        System.out.println("Appium Server URL: " + appiumServerUrl);
//
//        // Fetch an integer property by key
//        int implicitlyWaitTimeout = propertiesManager.getIntProperty("implicitly.wait.timeout");
//        System.out.println("Implicitly Wait Timeout: " + implicitlyWaitTimeout);
//
//        // Fetch a boolean property by key
//        boolean enableLogging = propertiesManager.getBooleanProperty("enable.logging");
//        System.out.println("Enable Logging: " + enableLogging);
//
//        // Fetch a double property by key
//        double appVersion = propertiesManager.getDoubleProperty("app.version");
//        System.out.println("App Version: " + appVersion);
//    }
}