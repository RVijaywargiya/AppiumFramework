package TestClasses;

import DataProviders.TestDataProviders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
// import org.testng.ITestResult;
// import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.PageManager;
import pages.ProductsPage;
// import utils.ScreenshotUtils;

// import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static utils.ScreenshotUtils.saveScreenshot;
// import static utils.ScreenshotUtils.takeScreenshot;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    ProductsPage productsPage;
    SoftAssert softAssert;
    Logger logger;
    PageManager pageManager;
//    private VideoRecordingUtil VideoRecorderUtil;

    @BeforeMethod
    public void setUp() throws Exception {
        logger = LogManager.getLogger(LoginTest.class);
        softAssert = new SoftAssert();
        pageManager = new PageManager(driver);
        loginPage = pageManager.getLoginPage();
//        VideoRecordingUtil.startRecording("videos", "testVideo");
    }

    @Test(priority = 1, dataProvider =  "successfulLogin", dataProviderClass = TestDataProviders.class)
    public void successfulLogin(String userName, String password) throws InterruptedException {
        loginPage.login(userName, password);
        productsPage = pageManager.getProductsPage();
        softAssert.assertEquals(productsPage.getProductsPageTitle(), "PRODUCTS", "Products page title is incorrect");
        saveScreenshot(driver);
        new ProductsPage(driver).openSideMenu().clickLogout();
    }

    @Test(priority = 2, dataProvider = "unsuccessfulLogin", dataProviderClass = TestDataProviders.class)
    public void verifyLockedOutUserMessage(String userName, String password) {
        loginPage.login(userName, password);
        String UNSUCCESSFUL_LOGIN_ERROR = "Sorry, this user has been locked out.";
        logger.info("Actual error message -> " + loginPage.getLockedOutUserErrorMessageText());
        assertEquals(loginPage.getLockedOutUserErrorMessageText(),
                UNSUCCESSFUL_LOGIN_ERROR,
                "Actual error message : " + loginPage.getLockedOutUserErrorMessageText() + "differs from expected error message");
        saveScreenshot(driver);

    }

    public void testVerticalScroll() {
        
    }

//    @AfterMethod
//    public void saveScreenshot() throws IOException {
////        if (result.getStatus() == ITestResult.FAILURE) {
//            new ScreenshotUtils().takeScreenshot(driver, ScreenshotUtils.getScreenshotDir() + );
////        }
//    }

}