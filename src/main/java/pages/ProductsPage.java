package pages;

import CommonComponents.Sidebar;
// import com.aventstack.extentreports.App;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage{

    public ProductsPage(AppiumDriver driver) {
        super(driver);
    }

    private final WebElement productsPageTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]"));

    private final WebElement sideMenuHamburger = driver.findElement(AppiumBy.accessibilityId("test-Menu"));

    public String getProductsPageTitle() {
        return getElementText(productsPageTitle);
    }

    public Sidebar openSideMenu() {
        clickElement(sideMenuHamburger);
        return new Sidebar(driver);
    }
}
