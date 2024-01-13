package DataProviders;

import org.testng.annotations.DataProvider;

public class TestDataProviders {

    @DataProvider(name = "successfulLogin")
    public static Object[][] loginTestData1() {
        return new Object[][] {
                {"standard_user", "secret_sauce"}
        };
    }

    @DataProvider(name = "unsuccessfulLogin")
    public static Object[][] loginTestData2() {
        return new Object[][] {
                {"locked_out_user", "secret_sauce"}
        };
    }
}
