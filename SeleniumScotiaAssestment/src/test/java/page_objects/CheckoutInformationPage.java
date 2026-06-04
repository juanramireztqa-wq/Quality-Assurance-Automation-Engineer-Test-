package page_objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInformationPage extends BasePage{

    @FindBy(xpath = "//input[@data-test='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@data-test='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@data-test='postalCode']")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//input[@data-test='continue']")
    private WebElement continueButton;

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    public void fillShippingInformation(String firstName, String lastName, String postalCode) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);
    }

    public void clickContinue() {
        continueButton.click();
    }
}
