package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class BasePage {

    AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }


}
