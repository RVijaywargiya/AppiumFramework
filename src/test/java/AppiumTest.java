import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumTest {

//    private static AppiumDriver<MobileElement> driver;

    private static AppiumDriver driver;

    public static void main(String[] args) {
        try {
            setUp();
            testLogin();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tearDown();
        }
    }

    public static void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9.0.0"); // Replace with your Android version
        capabilities.setCapability("deviceName", "pixel_xl"); // Replace with your device name
        capabilities.setCapability("app", "D:\\Learning\\AppiumFramework\\src\\test\\resources\\apps\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp"); // Replace with your app package
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity"); // Replace with your app activity
        capabilities.setCapability("automationName", "uiautomator2");

        URL appiumServerURL = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(appiumServerURL, capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void testLogin() {
        // Replace these with the actual resource IDs or XPath of the login elements
//        MobileElement usernameField = (MobileElement) driver.findElement(MobileBy.AccessibilityId("your_username_field_id"));
        WebElement usernameField = driver.findElement(AppiumBy.accessibilityId("test-Username"));
        WebElement passwordField = driver.findElement(AppiumBy.accessibilityId("test-Password"));
        WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));

        // Replace these with your test data
        String username = "standard_user";
        String password = "secret_sauce";

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        // Add assertions or further actions based on your test requirements
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}