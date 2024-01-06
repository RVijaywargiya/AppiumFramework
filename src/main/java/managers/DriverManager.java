package managers;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static managers.CapabilitiesManager.getDesiredCapabilities;

public class DriverManager {

    public static final String URL = "http://0.0.0.0:4723";
    private AppiumDriver driver;

    public DriverManager(AppiumDriver driver) {
        this.driver = driver;
    }

    public AppiumDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            URL appiumServerURL = new URL(URL);
            try {
                driver = new AppiumDriver(appiumServerURL, getDesiredCapabilities());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }
}
