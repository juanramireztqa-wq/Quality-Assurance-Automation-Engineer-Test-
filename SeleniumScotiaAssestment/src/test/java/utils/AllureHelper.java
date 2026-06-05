package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * Utility class for Allure reporting. Provides a method to take screenshots and attach them to Allure reports.
 */
public class AllureHelper {
    public static void screenshotToAllure(String name, WebDriver driver) {
        try {
            if (driver == null) {
                Allure.addAttachment("screenshot-error", new ByteArrayInputStream("driver is null".getBytes(StandardCharsets.UTF_8)));
                return;
            }
            byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(name, "image/png", new ByteArrayInputStream(bytes), ".png");
        } catch (Throwable t) {
            // attach error text to allure to debug
            Allure.addAttachment("screenshot-exception", t.getClass().getSimpleName() + ": " + t.getMessage());
        }
    }
}