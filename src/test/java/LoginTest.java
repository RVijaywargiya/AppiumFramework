import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    @Test
    public static void successfulLogin() throws InterruptedException {
        logger = LogManager.getLogger(LoginTest.class);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        Thread.sleep(5000);
    }
}