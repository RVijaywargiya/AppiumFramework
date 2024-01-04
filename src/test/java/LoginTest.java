import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.JsonUtils;

import java.net.MalformedURLException;

import static utils.JsonUtils.getJsonData;

public class LoginTest extends BaseTest{

    @Test
    public static void successfulLogin() throws InterruptedException {
        logger = LogManager.getLogger(LoginTest.class);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(getJsonData("username"), getJsonData("password"));
        Thread.sleep(5000);
    }
}