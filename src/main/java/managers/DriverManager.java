package managers;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    public static final String URL = "http://127.0.0.1:4723";
    private AppiumDriver driver;

    public AppiumDriver getDriver() throws MalformedURLException {
        setDriver();
        return driver;
    }

    private void setDriver() throws MalformedURLException {
        if (driver == null) {
            URL appiumServerURL = new URL(URL);
            driver = new AppiumDriver(appiumServerURL, new CapabilitiesManager().getDesiredCapabilities());
        }
    }


}
