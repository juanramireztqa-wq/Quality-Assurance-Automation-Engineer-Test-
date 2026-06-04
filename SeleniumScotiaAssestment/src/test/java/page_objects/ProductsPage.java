package page_objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {
    @FindBy(xpath = "//button[@data-test='add-to-cart-sauce-labs-backpack']")
    private WebElement firstProductATC;

    @FindBy(xpath = "//span[@data-test='shopping-cart-badge']")
    private WebElement cartIcon;

    @FindBy(xpath = "(//div[@data-test='inventory-item-name'])[1]")
    private WebElement firstProductName;

    @FindBy(xpath = "  (//div[@data-test='inventory-item-price'])[1]")
    private WebElement firstProductPrice;



    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addFirstProductToCart() {
        firstProductATC.click();
    }

    public void openCart() {
        cartIcon.click();
    }

    public String getFirstProductName(){
        return firstProductName.getText().trim();
    }

    public String getFirstProductPrice(){
        return firstProductPrice.getText().trim();
    }

    public String getCartIconText() {
        return cartIcon.getText().trim();
    }

}
