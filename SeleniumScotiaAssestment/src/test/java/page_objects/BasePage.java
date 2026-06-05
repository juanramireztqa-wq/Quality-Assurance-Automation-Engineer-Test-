package page_objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Base class for Page Objects.
 * Contains common utilities (presence check, text retrieval,
 * and resilient click) to keep consistency and reduce duplication
 *
 * @author Juan Ramirez
 */

public class BasePage {
    protected WebDriver driver;

    /**
     * Constructor initializes the WebDriver and PageFactory elements.
     *
     * @param driver WebDriver instance to be used by page objects.
     *               Initializes WebElements annotated with @FindBy in subclasses.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Checks if a WebElement is present and displayed on the page.
     *
     * @param element WebElement to check for presence.
     * @return true if the element is not null and is displayed; false otherwise.
     */
    public boolean isPresent(WebElement element) {
        try {
            return element != null && element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retrieves the text from a WebElement, with an option to trim whitespace.
     *
     * @param element WebElement from which to retrieve text.
     * @param trim    If true, the returned text will be trimmed of leading and trailing whitespace.
     * @return The text content of the element, or an empty string if the element is null or an error occurs.
     */
    public String getText(WebElement element, boolean trim) {
        try {
            if (element == null) return "";
            String text = element.getText();
            return trim ? text.trim() : text;
        } catch (Throwable t) {
            return "";
        }
    }

    /**
     * @param driver  WebDriver instance to use for waiting and executing JavaScript.
     * @param element WebElement to be clicked.
     *                This method attempts to click the given element using a standard WebDriver click after waiting for
     *                it to be clickable. If that fails, it falls back to using JavaScript to perform the click.
     */
    public static void click(WebDriver driver, WebElement element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Throwable t) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }


}
