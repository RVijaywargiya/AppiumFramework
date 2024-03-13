package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
// import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
// import managers.PropertiesManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

public class ExtentReportListener implements ITestListener {

    private ExtentReports extentReports;
    private ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {
        extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-report.html");
        sparkReporter.config().setDocumentTitle("Appium Framework");
        sparkReporter.config().setReportName("MyApp");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setCss("body, h1, h2, h3, h4, h5, h6 { font-size: 16px !important; }");
        extentReports.attachReporter(sparkReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
//        extentTest = extentReports.createTest(result.getName())
//                .addScreenCaptureFromPath(ScreenshotUtils.getScreenshotPath())
//                .pass(MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtils.getScreenshotPath()).build());
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.INFO, "Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, MarkupHelper.createLabel("Test passed", ExtentColor.GREEN));
        extentTest.addScreenCaptureFromPath(ScreenshotUtils.getScreenshotDir());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, MarkupHelper.createLabel("Test failed", ExtentColor.RED));
        extentTest.log(Status.FAIL, result.getThrowable());
        extentTest.addScreenCaptureFromPath(ScreenshotUtils.getScreenshotDir());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, MarkupHelper.createLabel("Test skipped", ExtentColor.YELLOW));
        extentTest.log(Status.SKIP, result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
