package managers;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesManager {

    public DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9.0.0"); // Replace with your Android version
        capabilities.setCapability("deviceName", "pixel_xl"); // Replace with your device name
        capabilities.setCapability("app", "D:\\Learning\\AppiumFramework\\src\\test\\resources\\apps\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp"); // Replace with your app package
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity"); // Replace with your app activity
        capabilities.setCapability("automationName", "uiautomator2");
        return capabilities;
    }
}
