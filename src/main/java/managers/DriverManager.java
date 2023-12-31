package managers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static managers.CapabilitiesManager.getDesiredCapabilities;

public class DriverManager {

    public static final String URL = "http://0.0.0.0:4723";
    private AppiumDriver driver;

    public AppiumDriver getDriver() throws MalformedURLException {
        setDriver();
        return driver;
    }

    private void setDriver() throws MalformedURLException {
        if (driver == null) {
            URL appiumServerURL = new URL(URL);
            try {
                driver = new AppiumDriver(appiumServerURL, getDesiredCapabilities());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("After driver instantiation");
    }




}
