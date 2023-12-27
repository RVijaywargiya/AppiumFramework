import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import managers.DriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    AppiumDriver driver = new DriverManager().getDriver();

    public BaseTest() throws MalformedURLException {
    }

    @BeforeTest
    public void setUp() throws Exception {
        driver = new DriverManager().getDriver();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
