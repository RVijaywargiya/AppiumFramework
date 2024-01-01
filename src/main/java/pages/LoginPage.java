package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    WebElement usernameField = driver.findElement(AppiumBy.accessibilityId("test-Username"));
    WebElement passwordField = driver.findElement(AppiumBy.accessibilityId("test-Password"));
    WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));

    // Replace these with your test data
    String username = "standard_user";
    String password = "secret_sauce";

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    private void enterUsername(String username) {
        // Clear and enter the username in the username field
        clearText(usernameField);
        logger.info("Clearing user name");
        enterText(usernameField, username);
        logger.info("Entering user name");
    }

    private void enterPassword(String password) {
        // Clear and enter the password in the password field
        clearText(passwordField);
        logger.info("Clearing password");
        enterText(passwordField, password);
        logger.info("Entering password");
    }

    private void clickLoginButton() {
        // Click the login button
        clickElement(loginButton);
        logger.info("Clicked login button");
    }

    public void login(String username, String password) {
        // Perform login by entering username and password, and clicking the login button
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
