package managers;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class CapabilitiesManager {

    public static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9.0.0"); // Replace with your Android version
        capabilities.setCapability("deviceName", "pixel_xl"); // Replace with your device name
        capabilities.setCapability("app", "D:" + File.separator + "Learning" + File.separator + "AppiumFramework" +
                File.separator + "src" + File.separator + "test" + File.separator +
                "resources" + File.separator + "apps" + File.separator +
                "Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp"); // Replace with your app package
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity"); // Replace with your app activity
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("avd", "Pixel_XL_API_30");
        capabilities.setCapability("avdLaunchTimeout", 180000);
        capabilities.setCapability("newCommandTimeout", 300);
        return capabilities;
    }
}
