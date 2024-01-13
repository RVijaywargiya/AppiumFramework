package TestClasses;

import DataProviders.TestDataProviders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

import static utils.JsonUtils.getJsonData;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    SoftAssert softAssert;
    Logger logger;

    private final String expectedUnsuccessfulLoginErrorMessage = "Sorry, this user has been locked out.";

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(driver);
        logger = LogManager.getLogger(LoginTest.class);
        softAssert = new SoftAssert();
    }

    @Test(priority = 0, dataProvider =  "successfulLogin", dataProviderClass = TestDataProviders.class)
    public void successfulLogin(String userName, String password) throws InterruptedException {
//        loginPage.login(getJsonData(0,"username"), getJsonData(0,"password"));
        loginPage.login(userName, password);

    }

    @Test(priority = 1, dataProvider = "unsuccessfulLogin", dataProviderClass = TestDataProviders.class)
    public void verifyLockedOutUserMessage(String userName, String password) {
        loginPage.login(userName, password);
        softAssert.assertEquals(loginPage.getLockedOutUserErrorMessageText(),
                expectedUnsuccessfulLoginErrorMessage,
                "Actual error message : " + loginPage.getLockedOutUserErrorMessageText() + "differs from expected error message");
    }


}