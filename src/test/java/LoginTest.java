import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

import java.time.Duration;

import static utils.JsonUtils.getJsonData;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    SoftAssert softAssert;
    Logger logger;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(driver);
        logger = LogManager.getLogger(LoginTest.class);
        softAssert = new SoftAssert();
    }

    @Test
    public void successfulLogin() throws InterruptedException {
//        logger = LogManager.getLogger(LoginTest.class);
//        softAssert = new SoftAssert();
//        loginPage = new LoginPage(driver);
        loginPage.login(getJsonData("username"), getJsonData("password"));
    }

    @Test
    public void verifyLockedOutUserMessage() {
//        loginPage = new LoginPage(driver);
        loginPage.login(getJsonData("username"), getJsonData("password"));
        softAssert.assertEquals(loginPage.getLockedOutUserErrorMessageText(),
                "Sorry, this user has been locked out.",
                "Actual error message : " + loginPage.getLockedOutUserErrorMessageText() + "differs from expected error message");
    }


}