import org.apache.logging.log4j.LogManager;
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
    WebDriverWait wait;

    SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        logger = LogManager.getLogger(LoginTest.class);
        softAssert = new SoftAssert();
        this.loginPage = new LoginPage(driver);
    }

    @Test
    public void successfulLogin() throws InterruptedException {
        loginPage.login(getJsonData("username"), getJsonData("password"));
    }

    @Test
    public void verifyLockedOutUserMessage() {
        loginPage.login(getJsonData("username"), getJsonData("password"));
        softAssert.assertEquals(loginPage.getLockedOutUserErrorMessageText(),
                "Sorry, this user has been locked out.",
                "Actual error message : " + loginPage.getLockedOutUserErrorMessageText() + "differs from expected error message");
    }


}