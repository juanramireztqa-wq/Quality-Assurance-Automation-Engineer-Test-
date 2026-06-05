package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object representing the Checkout: Overview page in the Sauce Demo application.
 * This page displays a summary of the items being purchased, including product name, quantity, price,
 * item total, tax, and overall total. It also includes a Finish button to complete the checkout process.
 */
public class CheckoutOverviewPage extends BasePage {
    // Product name shown in the overview (line item)
    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    private WebElement productName;
    // Quantity element for the line item
    @FindBy(xpath = "//div[@data-test='item-quantity']")
    private WebElement productQuantity;
    // Price displayed for the product line
    @FindBy(xpath = "//div[@data-test='inventory-item-price']")
    private WebElement productPrice;
    // Subtotal / item total labe
    @FindBy(xpath = "//div[@data-test='subtotal-label']")
    private WebElement itemTotalLabel;
    // Tax label
    @FindBy(xpath = "//div[@data-test='tax-label']")
    private WebElement taxLabel;
    // Total label
    @FindBy(xpath = "//div[@data-test='total-label']")
    private WebElement totalLabel;
    // Finish button to complete the checkout flow
    @FindBy(xpath = "//button[@data-test='finish']")
    private WebElement finishButton;
    // Title element used to verify the Checkout: Overview page is displayed
    @FindBy(xpath = "//span[@data-test='title' and text()='Checkout: Overview']")
    private WebElement overviewTitle;

    /**
     * Constructor for the CheckoutOverviewPage. Initializes the WebDriver and PageFactory elements.
     *
     * @param driver The WebDriver instance to interact with the page.
     */
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Returns the product name text (trimmed) from the overview page. This is used to verify that the correct item is being purchased.
     *
     * @return The product name text.
     */
    public String getProductName() {
        return getText(productName, true);
    }

    /**
     * Returns the product quantity text (trimmed).
     *
     * @return The product quantity text.
     */
    public String getProductQuantity() {
        return getText(productQuantity, true);
    }

    /**
     * Returns the product price text (trimmed). Caller should parse to numeric for calculations
     *
     * @return The product price text.
     */
    public String getProductPrice() {
        return getText(productPrice, true);
    }

    /**
     * Returns the raw item total label text (trimmed).
     *
     * @return The raw item total label text.
     */
    public String getItemTotalRaw() {
        return getText(itemTotalLabel, true);
    }

    /**
     * Returns the raw tax label text (trimmed). Parse numeric portion for assertions.
     *
     * @return The raw tax label text.
     */
    public String getTaxRaw() {
        return getText(taxLabel, true);
    }

    /**
     * Returns the raw total label text (trimmed). Parse and verify equals item total + tax.
     *
     * @return The raw total label text.
     */
    public String getTotalRaw() {
        return getText(totalLabel, true);
    }

    /**
     * Verifies that the Checkout: Overview page is displayed by checking the title element.
     *
     * @return True if the page is displayed, false otherwise.
     */
    public boolean isCheckoutOverviewPageDisplayed() {
        return isPresent(overviewTitle);
    }

    /**
     * Clicks the Finish button using the resilient click helper from BasePage.
     */
    public void clickFinish() {
        click(driver, finishButton);
    }
}
