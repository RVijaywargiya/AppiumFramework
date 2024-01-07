package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    WebElement usernameField = driver.findElement(AppiumBy.accessibilityId("test-Username"));
    WebElement passwordField = driver.findElement(AppiumBy.accessibilityId("test-Password"));
    WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));
    WebElement lockedOutUserErrorMessage = driver.findElement(AppiumBy.accessibilityId("test-Error message"));

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

//    public LoginPage getLoginPage() {
//        return new LoginPage(driver);
//    }

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
        waitForLoginPageToBeVisible();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public WebElement getUsernameField() {
        return usernameField;
    }

    public String getLockedOutUserErrorMessageText() {
        return getElementText(lockedOutUserErrorMessage);
    }

    private void waitForLoginPageToBeVisible() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Use a loop to wait until the login page element is visible
        while (true) {
            try {
                // Check if the login button is visible
                wait.until(ExpectedConditions.visibilityOf(getUsernameField()));
                break; // Break the loop if the element is found
            } catch (Exception e) {
                // Log or print a message if the element is not found yet
                logger.info("Login page element not found. Waiting...");
            }
        }
    }
}
