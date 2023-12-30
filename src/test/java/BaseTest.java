import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import managers.CapabilitiesManager;
import managers.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected static AppiumDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        startAppiumServer();
        startEmulator();
        driver = new DriverManager().getDriver();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private static AppiumDriverLocalService startAppiumServer() {
        // Specify the path to the Appium.js file (you may need to adjust the path)
        String appiumPath = "C:\\Users\\rajat\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\appium.js\"";

        // Create Appium service builder
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File(appiumPath))
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info");

        // Start the Appium server
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(serviceBuilder);
        service.start();
        return service;
    }

    public static void startEmulator() {
        AppiumDriverLocalService service = startAppiumServer();

        // Set the Appium server URL
        URL appiumServerURL = service.getUrl();

        // Create Appium Driver
        AppiumDriver driver = new AndroidDriver(appiumServerURL, CapabilitiesManager.getDesiredCapabilities());

    }
}
