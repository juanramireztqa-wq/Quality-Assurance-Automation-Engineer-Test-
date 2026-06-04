package page_objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletedPage extends BasePage{

    @FindBy(xpath = "//span[@data-test='title']")
    private WebElement completeMessage;

    @FindBy(xpath = "//a[@data-test='shopping-cart-link']")
    private WebElement cartIcon;

    @FindBy(xpath = "//button[@data-test='back-to-products']")
    private WebElement backHomeButton;

    public CheckoutCompletedPage(WebDriver driver) {
        super(driver);
    }

    public String getCompleteMessageText() {
        return completeMessage.getText().trim();
    }

    public boolean isCartBadgeEmpty() {
        return cartIcon.getText().trim().isEmpty();
    }

    public void clickBackHome() {
        backHomeButton.click();
    }
}
