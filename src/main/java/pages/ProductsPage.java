package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage{

    public ProductsPage(AppiumDriver driver) {
        super(driver);
    }

    WebElement productsPageTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]"));

    public String getProductsPageTitle() {
        return getElementText(productsPageTitle);
    }
}
