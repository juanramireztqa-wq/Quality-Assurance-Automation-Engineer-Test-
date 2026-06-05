package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object for the Login page of the Sauce Demo application.
 */
public class LoginPage extends BasePage {
    // username input field
    @FindBy(xpath = "//input[@data-test='username']")
    private WebElement usernameInput;
    // Password input field
    @FindBy(xpath = "//input[@data-test='password']")
    private WebElement passwordInput;
    // Login button (submit)
    @FindBy(xpath = "//input[@type='submit' and @data-test='login-button']")
    private WebElement loginButton;

    /**
     * Constructor for LoginPage.
     *
     * @param driver The WebDriver instance to be used for interacting with the page.
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigate to the login page URL.
     *
     * @param url The URL of the login page (e.g., "https://www.saucedemo.com/").
     */
    public void open(String url) {
        driver.get(url);
    }

    /**
     * Perform login action by entering the provided username and password
     *
     * @param username The username to be entered in the login form (e.g., "standard_user").
     * @param password The password to be entered in the login form (e.g., "secret_sauce").
     */
    public void login(String username, String password) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        click(driver, loginButton);
    }
}
