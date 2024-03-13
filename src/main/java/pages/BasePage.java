package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofMillis;
import static java.util.Collections.singletonList;

public class BasePage {

    protected AppiumDriver driver;
    WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
    }

    public void enterText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }
    public void clearText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public String getElementText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public String getElementText(By by) {
        return driver.findElement(by).getText();
    }

    public void performVerticalScroll(Point source) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(ofMillis(0),
                PointerInput.Origin.viewport(), source.x, source.y));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        sequence.addAction(new Pause(finger, ofMillis(600)));
        sequence.addAction(finger.createPointerMove(ofMillis(600),
                PointerInput.Origin.viewport(), source.x + 400, source.y));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

        driver.perform(singletonList(sequence));
    }

}
