import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import managers.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

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

    private static void startAppiumServer() {
        // Specify the path to the Appium.js file (you may need to adjust the path)
        String appiumPath = "C:\\Users\\rajat\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\appium.js";

        // Create Appium service builder
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File(appiumPath))
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info");

        // Start the Appium server
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(serviceBuilder);
        service.start();
    }

    public static void startEmulator() {

        final String ANDROID_HOME = "C:\\Users\\rajat\\AppData\\Local\\Android\\Sdk";

        try {
            String emulatorPath = ANDROID_HOME + "\\emulator\\emulator.exe";

            // Command to start the emulator
            String command = emulatorPath + " -avd " + avdName;

            // Start the emulator using the command
            Process process = Runtime.getRuntime().exec(command);

            // Optionally, wait for the process to finish (emulator fully started)
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
