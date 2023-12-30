import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import managers.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    protected static AppiumDriver driver;
    private static AppiumDriverLocalService appiumService;

    @BeforeTest
    public void setUp() throws Exception {
        startAppiumServer();
        startEmulator();
        driver = new DriverManager().getDriver();
    }

    @AfterTest
    public void tearDown() throws IOException, InterruptedException {
        if (driver != null) {
            driver.quit();
        }
        stopEmulator();
        appiumService.stop();
    }

    private void stopEmulator() throws InterruptedException, IOException {
        String adbCommand = "adb emu kill";
        Process process = Runtime.getRuntime().exec(adbCommand);
        process.waitFor();
    }

    private static void startAppiumServer() {
        // Specify the path to the Appium.js file (you may need to adjust the path)
//        String appiumPath = "C:\\Users\\rajat\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\appium.js";
//
//        // Create Appium service builder
//        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
//                .withAppiumJS(new File(appiumPath))
//                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
//                .withArgument(GeneralServerFlag.LOG_LEVEL, "info");
//
//        // Start the Appium server
//        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(serviceBuilder);
//        service.start();

        // Start Appium server
        Duration startUpTimeout = Duration.ofSeconds(300);
        appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .withAppiumJS(new java.io.File("C:\\Users\\rajat\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\appium.js"))
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                        .withTimeout(startUpTimeout));

        appiumService.start();

    }

    public static void startEmulator() throws IOException, InterruptedException {
        // Start Android emulator
        // Replace "Pixel_3a_API_30" with the name of your AVD (Android Virtual Device)
        String emulatorCommand = "emulator -avd Pixel_XL_API_30";
        Process process = Runtime.getRuntime().exec(emulatorCommand);
        process.waitFor();
    }
}
