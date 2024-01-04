package managers;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class CapabilitiesManager {

    public static DesiredCapabilities getDesiredCapabilities() {
        PropertiesManager propertiesManager = new PropertiesManager();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", propertiesManager.getProperty("platformName"));
        capabilities.setCapability("udid", propertiesManager.getProperty("udid"));
        capabilities.setCapability("deviceName", propertiesManager.getProperty("deviceName")); // Replace with your device name
        capabilities.setCapability("app", "D:" + File.separator + "Learning" + File.separator + "AppiumFramework" +
                File.separator + "src" + File.separator + "test" + File.separator +
                "resources" + File.separator + "apps" + File.separator +
                "Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        capabilities.setCapability("appPackage", propertiesManager.getProperty("appPackage")); // Replace with your app packag)e
        capabilities.setCapability("appActivity", propertiesManager.getProperty("appActivity")); // Replace with your app activit)y
        capabilities.setCapability("automationName", propertiesManager.getProperty("automationName"));
        capabilities.setCapability("avd", propertiesManager.getProperty("avd"));
        capabilities.setCapability("avdLaunchTimeout", propertiesManager.getProperty("avdLaunchTimeout"));
        capabilities.setCapability("systemPort", propertiesManager.getDoubleProperty("systemPort"));
        return capabilities;
    }
}
