package managers;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class AppiumServerManager {
    private static AppiumDriverLocalService appiumService;
    private static final Logger logger = LogManager.getLogger(AppiumServerManager.class);

    public static void startAppiumServer() {
        logger.info("Starting Appium server...");
        Duration startUpTimeout = Duration.ofSeconds(300);
        appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingPort(4723)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
                .withTimeout(startUpTimeout));

        appiumService.start();
    }

    public static void stopAppiumServer() {
        if (appiumService != null) {
            appiumService.stop();
            logger.info("Appium server stopped...");
        }
    }

    public static boolean isAppiumServerRunning() {
        return appiumService.isRunning();
    }
}