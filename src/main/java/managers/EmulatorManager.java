package managers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class EmulatorManager {
    private static final Logger logger = LogManager.getLogger(EmulatorManager.class);

    public static void startEmulator() throws IOException, InterruptedException {
        logger.info("Starting Emulator...");
        String emulatorCommand = "cmd /c start C:\\Users\\rajat\\AppData\\Local\\Android\\Sdk\\emulator\\emulator -avd Pixel_XL_API_30";
        Process process = Runtime.getRuntime().exec(emulatorCommand);
        process.waitFor();
        logger.info("Emulator has been started...");
    }

    public static void stopEmulator() throws InterruptedException, IOException {
        String adbCommand = "adb emu kill";
        Process process = Runtime.getRuntime().exec(adbCommand);
        process.waitFor();
    }
}