package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object representing the Checkout Information page of the Sauce Demo application.
 * This page is where users enter their shipping information before proceeding to the order overview.
 * It provides methods to interact with the form fields and the continue button.
 */
public class CheckoutInformationPage extends BasePage {

    // First name input field
    @FindBy(xpath = "//input[@data-test='firstName']")
    private WebElement firstNameInput;
    // Last name input field
    @FindBy(xpath = "//input[@data-test='lastName']")
    private WebElement lastNameInput;
    // Postal code / ZIP input field
    @FindBy(xpath = "//input[@data-test='postalCode']")
    private WebElement postalCodeInput;
    // Continue button to navigate to Checkout: Overview
    @FindBy(xpath = "//input[@data-test='continue']")
    private WebElement continueButton;

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Fills in the shipping information form with the provided first name, last name, and postal code.
     *
     * @param firstName  The first name to enter in the shipping information form.
     * @param lastName   The last name to enter in the shipping information form.
     * @param postalCode The postal code to enter in the shipping information form.
     */
    public void fillShippingInformation(String firstName, String lastName, String postalCode) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);
    }

    /**
     * Clicks the continue button to proceed to the Checkout: Overview page.
     */
    public void clickContinue() {
        click(driver, continueButton);
    }
}
