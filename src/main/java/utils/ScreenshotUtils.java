package utils;

import io.appium.java_client.AppiumDriver;
import managers.PropertiesManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtils {

    private final AppiumDriver driver;

    private static Path destinationPath;

    public ScreenshotUtils(AppiumDriver driver) {
        this.driver = driver;
    }

    public void captureScreenshot(String methodName) {
        try {
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Specify the directory where you want to store the screenshot
            destinationPath = Path.of("D:" + File.separator + "Learning" + File.separator + "AppiumFramework" + File.separator + "src" +
                    File.separator + "test" + File.separator + "resources" + File.separator + "screenshots", methodName + "_screenshot.png");

            // Copy the screenshot to the specified directory
            Files.copy(sourceFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot captured: " + destinationPath.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    public static String getScreenshotPath() {
        return destinationPath.toAbsolutePath().toString();
    }
}
