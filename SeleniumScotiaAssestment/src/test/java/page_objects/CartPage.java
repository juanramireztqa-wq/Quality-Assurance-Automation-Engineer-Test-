package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object for the Cart page.
 * Encapsulates elements and actions related to the shopping cart, such as product name, price, quantity, and proceeding to checkout.
 */
public class CartPage extends BasePage {
    // Product price displayed in the cart (visible next to the item)
    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    private WebElement productName;
    // "Checkout" button to start the checkout flow from the cart page
    @FindBy(xpath = "//div[@data-test='inventory-item-price']")
    private WebElement productPrice;
    // Quantity element for the cart line item
    @FindBy(xpath = "//button[@data-test='checkout']")
    private WebElement checkoutButton;
    // Title element used to verify the Cart page is displayed
    @FindBy(xpath = "//div[@data-test='item-quantity']")
    private WebElement productQuantity;
    // Title element used to verify the Cart page is displayed
    @FindBy(xpath = "//span[@data-test='title' and text()='Your Cart']")
    private WebElement cartTitle;

    /**
     * Constructor for CartPage. Initializes the page object with the WebDriver instance.
     *
     * @param driver The WebDriver instance used to interact with the web page.
     */
    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Returns the product name text from the cart (trimmed).
     *
     * @return The trimmed product name text from the cart.
     */
    public String getCartProductName() {
        return getText(productName, true);
    }

    /**
     * Returns the product price text from the cart (trimmed).
     *
     * @return The trimmed product price text from the cart.
     */
    public String getCartProductPrice() {
        return getText(productPrice, true);
    }

    /**
     * Clicks the Checkout button to navigate to the Checkout: Your Information page.
     */
    public void clickCheckout() {
        click(driver, checkoutButton);
    }

    /**
     * Returns the quantity text for the cart item.
     *
     * @return The trimmed product quantity text from the cart.
     */
    public String getProductQuantity() {
        return getText(productQuantity, true);
    }

    /**
     * Verifies that the Cart page is displayed by checking the title element.
     *
     * @return true if the Cart page is displayed, false otherwise.
     */
    public boolean isCartPageDisplayed() {
        return isPresent(cartTitle);
    }


}
