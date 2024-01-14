package TestClasses;

import DataProviders.TestDataProviders;
import managers.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.PageManager;
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

    @BeforeMethod
    public void setUp() throws MalformedURLException, InterruptedException {
        setUpDriver();
        logger = LogManager.getLogger(LoginTest.class);
        softAssert = new SoftAssert();
        pageManager = new PageManager(driver);
        loginPage = pageManager.getLoginPage();
    }

    private static void setUpDriver() throws MalformedURLException {
        driver = new DriverManager(driver).getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(propertiesManager.getIntProperty("implicitly.wait.timeout")));
    }


    @Test(priority = 1, dataProvider =  "successfulLogin", dataProviderClass = TestDataProviders.class)
    public void successfulLogin(String userName, String password) throws InterruptedException {
        loginPage.login(userName, password);
        productsPage = pageManager.getProductsPage();
        softAssert.assertEquals(productsPage.getProductsPageTitle(), "PRODUCTS", "Products page title is incorrect");
        new ProductsPage(driver).openSideMenu().clickLogout();
    }

    @Test(priority = 2, dataProvider = "unsuccessfulLogin", dataProviderClass = TestDataProviders.class)
    public void verifyLockedOutUserMessage(String userName, String password) {
        loginPage.login(userName, password);
        String UNSUCCESSFUL_LOGIN_ERROR = "Sorry, this user has been locked out.";
        softAssert.assertEquals(loginPage.getLockedOutUserErrorMessageText(),
                UNSUCCESSFUL_LOGIN_ERROR,
                "Actual error message : " + loginPage.getLockedOutUserErrorMessageText() + "differs from expected error message");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            new ScreenshotUtils(driver).captureScreenshot(result.getMethod().getMethodName());
        }
    }
}