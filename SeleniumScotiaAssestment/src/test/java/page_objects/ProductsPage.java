package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object for the Products/Inventory page.
 * Encapsulates locators and high-level interactions for assertions and actions
 * performed on the product listing page after login.
 * Provides methods to add products to the cart, verify product details,
 * and navigate to the cart page.
 */

public class ProductsPage extends BasePage {
    @FindBy(xpath = "//button[@data-test='add-to-cart-sauce-labs-backpack']")
    private WebElement firstProductATC;

    @FindBy(xpath = "//div[@data-test='inventory-item-name' and text()='Sauce Labs Backpack']")
    private WebElement firstProductName;

    @FindBy(xpath = "  (//div[@data-test='inventory-item-price'])[1]")
    private WebElement firstProductPrice;

    @FindBy(xpath = "//span[@data-test='title' and text()='Products']")
    private WebElement productsTitle;

    @FindBy(xpath = "//a[@data-test='shopping-cart-link']")
    private WebElement cartIcon;

    @FindBy(xpath = "//span[@data-test='shopping-cart-badge']")
    private WebElement cartBadge;

    /**
     * Constructor for the ProductsPage.
     * Initializes the page object with the WebDriver instance.
     *
     * @param driver The WebDriver instance to interact with the web page.
     */
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks the "Add to Cart" button for the first product (Sauce Labs Backpack).
     */
    public void addFirstProductToCart() {
        click(driver, firstProductATC);
    }

    /**
     * Verifies the Inventory/Products page is displayed by checking the title element.
     *
     * @return true if the page is displayed, false otherwise.
     */
    public boolean isInventoryPresent() {
        return isPresent(productsTitle);
    }

    /**
     * Validates the presence of the cart icon.
     *
     * @return true if the cart icon is present, false otherwise.
     */
    public boolean cartIconValidation() {
        return isPresent(cartBadge);
    }

    /**
     * Retrieves the price text for the first product (trimmed).
     *
     * @return The price text for the first product.
     */
    public String getFirstProductPrice() {
        return getText(firstProductPrice, true);
    }

    /**
     * Returns the product name text for the first product (trimmed).
     *
     * @return The product name text for the first product.
     */
    public String getFirstProductName() {
        return getText(firstProductName, true);
    }

    /**
     * Clicks the cart icon to navigate to the Cart page.
     * Uses the resilient click helper from BasePage to ensure reliable interaction.
     */
    public void clickCartIcon() {
        click(driver, cartIcon);
    }


}
