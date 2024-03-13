package utils;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

public class ScreenshotUtils {

    @Getter
    static String screenshotDir = "D:" + File.separator + "Learning" + File.separator + "AppiumFramework"
            + File.separator + "src" + File.separator + "test" + File.separator + "resources"
            + File.separator + "screenshots";

    public static void takeScreenshot(WebDriver driver, String screenshotPath) {
        // Convert WebDriver instance to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture screenshot as FILE
        File scrFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            // Copy the screenshot to the desired location
            // You can customize the path and file name as needed
            org.apache.commons.io.FileUtils.copyFile(scrFile, new File(screenshotPath));
            System.out.println("Screenshot captured at: " + screenshotPath);
        } catch (IOException e) {
            System.err.println("Error while saving screenshot: " + e.getMessage());
        }
    }

    public static void saveScreenshot(WebDriver driver) {
        String fileName = UUID.randomUUID().toString() + ".png";
        String screenshotPath = ScreenshotUtils.getScreenshotDir() + File.separator + fileName;
        takeScreenshot(driver, screenshotPath);
    }

}
