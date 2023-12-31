import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    @Test
    public static void testLogin() throws InterruptedException {
        logger = LogManager.getLogger(LoginTest.class);
        LoginPage loginPage = new LoginPage(driver);
        logger.info("Entering user name");
        loginPage.enterUsername("standard_user");
        logger.info("Entering password");
        loginPage.enterPassword("secret_sauce");
        logger.info("Clicking login button");
        loginPage.clickLoginButton();
        Thread.sleep(5000);
    }
}