package TestClasses;

import CommonComponents.Sidebar;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import managers.DriverManager;
import managers.PropertiesManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.PageManager;
import pages.ProductsPage;
import utils.ScreenshotUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected static AppiumDriver driver;
    protected static WebDriverWait wait;
    private static AppiumDriverLocalService appiumService;
    protected static Logger logger;
    protected static PropertiesManager propertiesManager;
    protected PageManager pageManager;

    public BaseTest() {
        logger = LogManager.getLogger(BaseTest.class);
        propertiesManager = new PropertiesManager();
    }

    @BeforeTest
    public void testSetUp() throws Exception {
        setUpLog4j2Property();
        startEmulator();
        startAppiumServer();
        setUpDriver();
        waitForAppiumServerToStart(appiumService);
    }

    @AfterTest
    public void tearDown() throws IOException, InterruptedException {
        driver.quit();
        stopAppiumServer();
        stopEmulator();
    }

    private void stopEmulator() throws InterruptedException, IOException {
        String adbCommand = "adb emu kill";
        Process process = Runtime.getRuntime().exec(adbCommand);
        process.waitFor();
    }

    private static void startAppiumServer() throws InterruptedException {
        // Start Appium server
        logger.info("Starting Appium server...");
        Duration startUpTimeout = Duration.ofSeconds(300);
        appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingPort(4723)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                .withTimeout(startUpTimeout));

        appiumService.start();
//        waitForAppiumServerToStart(appiumService);
    }

    public static void startEmulator() throws IOException, InterruptedException {
        logger.info("Starting Emulator...");
        String emulatorCommand = "cmd /c start C:\\Users\\rajat\\AppData\\Local\\Android\\Sdk\\emulator\\emulator -avd Pixel_XL_API_30";
        Process process = Runtime.getRuntime().exec(emulatorCommand);
        process.waitFor();
        logger.info("Emulator has been started...");
    }

    private static void waitForAppiumServerToStart(AppiumDriverLocalService appiumServerService) {
        try {
            // Set a timeout based on your requirements
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // Use a condition that checks if the Appium server is running
            wait.until(driver -> appiumServerService.isRunning());
            logger.info("Appium server started successfully...");
        } catch (Exception e) {
            // Print the stack trace for better debugging
            e.printStackTrace();
            // Handle the exception or log an error
            logger.info("Error waiting for Appium server to start: " + e.getMessage());
        }
    }

    public static void setUpLog4j2Property() {
        System.setProperty("log4j.configurationFile", propertiesManager.getProperty("log4j.configurationFile"));
    }

    public static void stopAppiumServer() {
        if (appiumService != null) {
            appiumService.stop();
            logger.info("Appium server stopped...");
        }
    }

    private static void setUpDriver() throws MalformedURLException {
        driver = new DriverManager(driver).getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(propertiesManager.getIntProperty("implicitly.wait.timeout")));
    }

}
