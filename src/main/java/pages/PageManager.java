package pages;

import io.appium.java_client.AppiumDriver;

public class PageManager {

    private final AppiumDriver driver;

    public PageManager(AppiumDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public ProductsPage getProductsPage() {
        return new ProductsPage(driver);
    }
}
