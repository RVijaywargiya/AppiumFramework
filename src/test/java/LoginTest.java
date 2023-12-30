import org.testng.annotations.Test;
import pages.LoginPage;

import java.net.MalformedURLException;

public class LoginTest extends BaseTest{

    public LoginTest() throws MalformedURLException {
    }

    @Test
    public static void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("");


    }
}