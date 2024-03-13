package managers;

import io.appium.java_client.AppiumDriver;
// import managers.PropertiesManager;

import java.net.MalformedURLException;
// import java.sql.DriverManager;
import java.time.Duration;

public class DriverSetup {
    private static AppiumDriver driver;
    private static final PropertiesManager propertiesManager = new PropertiesManager();

    public static AppiumDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            driver = new AppiumDriver(CapabilitiesManager.getDesiredCapabilities());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(propertiesManager.getIntProperty("implicitly.wait.timeout")));
        }
        return driver;
    }
}