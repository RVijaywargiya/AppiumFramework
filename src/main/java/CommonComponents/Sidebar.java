package CommonComponents;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class Sidebar extends BasePage {
    public Sidebar(AppiumDriver driver) {
        super(driver);
    }

    private final WebElement LOGOUT = driver.findElement(AppiumBy.accessibilityId("test-LOGOUT"));

    public void clickLogout() {
        clickElement(LOGOUT);
    }



}
