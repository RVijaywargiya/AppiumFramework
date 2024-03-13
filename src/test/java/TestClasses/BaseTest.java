package TestClasses;

import io.appium.java_client.AppiumDriver;
import managers.AppiumServerManager;
import managers.DriverSetup;
import managers.EmulatorManager;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected static AppiumDriver driver;
    protected static Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeTest
    public void testSetUp() throws Exception {
        AppiumServerManager.startAppiumServer();
        EmulatorManager.startEmulator();
        driver = DriverSetup.getDriver();
    }

    @AfterTest
    public void tearDown() throws IOException, InterruptedException {
        driver.quit();
        AppiumServerManager.stopAppiumServer();
        EmulatorManager.stopEmulator();
    }
}