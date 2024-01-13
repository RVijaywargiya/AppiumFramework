package TestClasses;

import DataProviders.TestDataProviders;
import managers.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ScreenshotUtils;

import java.net.MalformedURLException;
import java.time.Duration;

import static utils.JsonUtils.getJsonData;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    ProductsPage productsPage;
    SoftAssert softAssert;
    Logger logger;

    private final String expectedUnsuccessfulLoginErrorMessage = "Sorry, this user has been locked out.";

    @BeforeMethod
    public void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        loginPage = new LoginPage(driver);
        logger = LogManager.getLogger(LoginTest.class);
        softAssert = new SoftAssert();
    }

    private static void setUpDriver() throws MalformedURLException, InterruptedException {
        driver = new DriverManager(driver).getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(propertiesManager.getIntProperty("implicitly.wait.timeout")));
    }

    @Test(priority = 1, dataProvider =  "successfulLogin", dataProviderClass = TestDataProviders.class)
    public void successfulLogin(String userName, String password) throws InterruptedException {
        loginPage.login(userName, password);
        productsPage = new ProductsPage(driver);
        softAssert.assertEquals(productsPage.getProductsPageTitle(), "PRODUCTS", "Products page title is incorrect");
        new ProductsPage(driver).openSideMenu().clickLogout();
    }

    @Test(priority = 2, dataProvider = "unsuccessfulLogin", dataProviderClass = TestDataProviders.class)
    public void verifyLockedOutUserMessage(String userName, String password) {
        loginPage.login(userName, password);
        softAssert.assertEquals(loginPage.getLockedOutUserErrorMessageText(),
                expectedUnsuccessfulLoginErrorMessage,
                "Actual error message : " + loginPage.getLockedOutUserErrorMessageText() + "differs from expected error message");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            new ScreenshotUtils(driver).captureScreenshot(result.getMethod().getMethodName());
        }
    }
}