package page_objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    private WebElement productName;

    @FindBy(xpath = "//div[@data-test='inventory-item-price']")
    private WebElement productPrice;

    @FindBy(xpath = "//button[@data-test='checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@data-test='item-quantity']")
    private WebElement productQuantity;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartProductName() {
        return productName.getText().trim();
    }

    public String getCartProductPrice() {
        return productPrice.getText().trim();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

    public String getProductQuantity() {
        return productQuantity.getText().trim();
    }

}
