import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import managers.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected static AppiumDriver driver;
    private static AppiumDriverLocalService appiumService;
    protected static Logger logger;

    @BeforeTest
    public void setUp() throws Exception {
        System.setProperty("log4j.configurationFile", "D:\\Learning\\AppiumFramework\\src\\test\\resources\\log4j2.xml");
        logger = LogManager.getLogger(BaseTest.class);
        startEmulator();
        startAppiumServer();
        driver = new DriverManager().getDriver();
        Thread.sleep(5000);
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

    private static void startAppiumServer() throws InterruptedException {
        // Start Appium server
        logger.info("Starting Appium server");
        Duration startUpTimeout = Duration.ofSeconds(300);
        appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingPort(4723)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                .withTimeout(startUpTimeout));

        appiumService.start();
        waitForAppiumServerToStart(appiumService);
    }

    public static void startEmulator() throws IOException, InterruptedException {
        logger.info("Starting Emulator : ");
        String emulatorCommand = "cmd /c start C:\\Users\\rajat\\AppData\\Local\\Android\\Sdk\\emulator\\emulator -avd Pixel_XL_API_30";
        Process process = Runtime.getRuntime().exec(emulatorCommand);
        process.waitFor();
        logger.info("Emulator has been started...");
    }

    private static void waitForAppiumServerToStart(AppiumDriverLocalService appiumServerService) {
        try {
            // Set a timeout based on your requirements
            URL serverUrl = new URL(appiumServerService.getUrl().toString());
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

            // Use a condition that checks if the server is reachable
            wait.until(ExpectedConditions.urlToBe(String.valueOf(serverUrl)));

            logger.info("Appium server started successfully...");
        } catch (Exception e) {
            // Handle the exception or log an error
            logger.info("Error waiting for Appium server to start..." + e.getMessage());
        }
    }
}
