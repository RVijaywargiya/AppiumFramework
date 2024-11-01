package managers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
// import managers.PropertiesManager;

import java.net.MalformedURLException;
// import java.sql.DriverManager;
import java.net.URL;
import java.time.Duration;

public class DriverSetup {
    private static AndroidDriver driver;
    private static final PropertiesManager propertiesManager = new PropertiesManager();

    public static AppiumDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), CapabilitiesManager.getDesiredCapabilities());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(propertiesManager.getIntProperty("implicitly.wait.timeout")));
        }
        return driver;
    }
}