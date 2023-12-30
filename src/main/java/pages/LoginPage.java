package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    WebElement usernameField = driver.findElement(AppiumBy.accessibilityId("test-Username"));
    WebElement passwordField = driver.findElement(AppiumBy.accessibilityId("test-Password"));
    WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));

    // Replace these with your test data
    String username = "standard_user";
    String password = "secret_sauce";

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        // Clear and enter the username in the username field
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        // Clear and enter the password in the password field
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        // Click the login button
        loginButton.click();
    }

    public void login(String username, String password) {
        // Perform login by entering username and password, and clicking the login button
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
