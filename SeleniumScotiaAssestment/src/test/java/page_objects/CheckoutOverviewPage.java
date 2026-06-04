package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    private WebElement productName;

    @FindBy(xpath = "//div[@data-test='item-quantity']")
    private WebElement productQuantity;

    @FindBy(xpath = "//div[@data-test='inventory-item-price']")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@data-test='subtotal-label']")
    private WebElement itemTotalLabel;

    @FindBy(xpath = "//div[@data-test='tax-label']")
    private WebElement taxLabel;

    @FindBy(xpath = "//div[@data-test='total-label']")
    private WebElement totalLabel;

    @FindBy(xpath = "//button[@data-test='finish']")
    private WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return productName.getText().trim();
    }

    public String getProductQuantity() {
        return productQuantity.getText().trim();
    }

    public String getProductPrice() {
        return productPrice.getText().trim();
    }

    public String getItemTotalRaw() {
        return itemTotalLabel.getText().trim();
    }

    public String getTaxRaw() {
        return taxLabel.getText().trim();
    }

    public String getTotalRaw() {
        return totalLabel.getText().trim();
    }

    public void clickFinish() {
        finishButton.click();
    }
}
