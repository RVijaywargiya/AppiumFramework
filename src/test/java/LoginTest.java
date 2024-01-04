import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

import static utils.JsonUtils.getJsonData;

public class LoginTest extends BaseTest{

    static LoginPage loginPage;
    static WebDriverWait wait;

    @Test
    public static void successfulLogin() throws InterruptedException {
        logger = LogManager.getLogger(LoginTest.class);
        loginPage = new LoginPage(driver);
        waitForLoginPageToBeVisible();
        loginPage.login(getJsonData("username"), getJsonData("password"));
//        Thread.sleep(5000);
    }

    private static void waitForLoginPageToBeVisible() {
//        By loginButtonLocator = By.id("loginButtonId");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Use a loop to wait until the login page element is visible
        while (true) {
            try {
                // Check if the login button is visible
                wait.until(ExpectedConditions.visibilityOf(loginPage.getUsernameField()));
                break; // Break the loop if the element is found
            } catch (Exception e) {
                // Log or print a message if the element is not found yet
                logger.info("Login page element not found. Waiting...");
            }
        }
    }
}