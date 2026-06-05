package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object representing the Checkout Completed page of the Sauce Demo application.
 * This page is displayed after a successful checkout process, confirming the order completion.
 * It includes elements to verify the success message, check the cart badge status, and navigate back
 */
public class CheckoutCompletedPage extends BasePage {
    // Header shown on successful checkout: "Thank you for your order!"
    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    private WebElement successMessage;
    // Page title element (generic title span) used to verify page visibility
    @FindBy(xpath = "//span[@data-test='title']")
    private WebElement checkoutCompleteTitle;
    // Cart icon in the header — present even on completion page.
    // Note: the cart icon itself does not expose the badge value here;
    // badge presence/absence should be validated against the badge element.
    @FindBy(xpath = "//a[@data-test='shopping-cart-link']")
    private WebElement cartIcon;
    // "Back Home" button that navigates back to the inventory/products page
    @FindBy(xpath = "//button[@data-test='back-to-products']")
    private WebElement backHomeButton;

    public CheckoutCompletedPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Retrieves the text of the success message displayed on the checkout completed page.
     *
     * @return The trimmed text of the success message element.
     */
    public String getSuccessMessageText() {
        return successMessage.getText().trim();
    }

    /**
     * Checks if the cart badge is empty by attempting to retrieve its text. If the badge is not present or has no text, it returns true.
     *
     * @return True if the cart badge is empty or not present, false if it contains any text (indicating items in the cart).
     */
    public boolean isCartBadgeEmpty() {
        return getText(cartIcon, true).isEmpty();
    }

    /**
     * Checks if the checkout complete title is visible.
     *
     * @return True if the title is visible, false otherwise.
     */
    public boolean isTitleVisible() {
        return isPresent(checkoutCompleteTitle);
    }

    /**
     * Clicks the Back Home button using the resilient click helper from BasePage.
     */
    public void clickBackHome() {
        backHomeButton.click();
    }
}
