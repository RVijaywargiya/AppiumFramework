import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumTest {

    private static final AppiumDriver driver;

    static {
        try {
            driver = new BaseTest().driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public static void testLogin() {
        WebElement usernameField = driver.findElement(AppiumBy.accessibilityId("test-Username"));
        WebElement passwordField = driver.findElement(AppiumBy.accessibilityId("test-Password"));
        WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));

        // Replace these with your test data
        String username = "standard_user";
        String password = "secret_sauce";

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}