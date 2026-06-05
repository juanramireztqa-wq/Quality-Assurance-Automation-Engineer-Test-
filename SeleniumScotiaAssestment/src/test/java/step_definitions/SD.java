package step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page_objects.*;

import java.util.List;

import io.qameta.allure.Step;

import java.util.Map;

import utils.AllureHelper;
import utils.SingleUser;

/**
 * This class contains the step definitions for the Cucumber tests. Each method corresponds to a step in the feature files.
 */
public class SD {
    private final WebDriver driver = Hooks.driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutInformationPage checkoutInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletedPage checkoutCompletePage;

    /**
     * This method is responsible for logging in the user with the provided username and password. It initializes the LoginPage and ProductsPage objects, opens the login page, performs the login action, takes a screenshot for Allure reporting, and asserts that the inventory page is displayed after a successful login.
     *
     * @param username The username to be used for login.
     * @param password The password to be used for login.
     */
    @Step("Given the user is logged in with {username} and {password}")
    @Given("the user is logged in with {string} and {string}")
    public void loginAs(String username, String password) {

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        loginPage.open("https://www.saucedemo.com/");
        loginPage.login(SingleUser.USERNAME, SingleUser.PASSWORD);
        AllureHelper.screenshotToAllure("Login Page", driver);
        Assert.assertTrue(productsPage.isInventoryPresent());

    }

    /**
     * This method simulates the action of adding the first product to the cart.
     */
    @Step("When the user adds first product to the cart")
    @When("the user adds first product to the cart")
    public void addProductToCart() {
        productsPage.addFirstProductToCart();
        Assert.assertTrue(productsPage.cartIconValidation());
        AllureHelper.screenshotToAllure("Product Added", driver);

    }

    /**
     * This method validates that the product added to the cart is displayed correctly in the cart page.
     */
    @Step("Then the user should see the product in the cart")
    @Then("the user should see the product in the cart")
    public void cartPageValidation() {
        cartPage = new CartPage(driver);
        String expectedName = productsPage.getFirstProductName();
        String expectedPrice = productsPage.getFirstProductPrice();
        String actualName = cartPage.getCartProductName();
        String actualPrice = cartPage.getCartProductPrice();
        productsPage.clickCartIcon();
        Assert.assertTrue(cartPage.isCartPageDisplayed());
        Assert.assertEquals("Product name in cart does not match", expectedName, actualName);
        Assert.assertEquals("Product price in cart does not match", expectedPrice, actualPrice);
        AllureHelper.screenshotToAllure("Cart View", driver);
        cartPage.clickCheckout();
    }

    /**
     * This method fills in the checkout information during the checkout process.
     *
     * @param dataTable The DataTable containing the checkout information, which includes first name, last name, and postal code.
     */
    @Step("When the user proceeds to checkout and adds the following information:")
    @When("the user proceeds to checkout and adds the following information:")
    public void fillCheckoutInformation(io.cucumber.datatable.DataTable dataTable) {
        // Convert DataTable to a Map
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        checkoutInformationPage = new CheckoutInformationPage(driver);
        String firstName = data.get(0).get("firstName");
        String lastName = data.get(0).get("lastName");
        String postalCode = data.get(0).get("postalCode");
        checkoutInformationPage.fillShippingInformation(firstName, lastName, postalCode);
        AllureHelper.screenshotToAllure("Information Filled", driver);
        checkoutInformationPage.clickContinue();

    }

    /**
     * This method validates that the information displayed in the checkout overview page matches the expected values.
     */
    @Step("Then the user should see the information in the checkout overview page")
    @Then("the user should see the information in the checkout overview page")
    public void validateCheckoutOverview() {
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        String expectedQty = cartPage.getProductQuantity();
        String expectedName = cartPage.getCartProductName();
        String expectedPrice = cartPage.getCartProductPrice();
        String actualName = checkoutOverviewPage.getProductName();
        String actualPrice = checkoutOverviewPage.getProductPrice();
        String actualQty = checkoutOverviewPage.getProductQuantity();
        Assert.assertEquals("Product name in cart does not match", expectedName, actualName);
        Assert.assertEquals("Product price in cart does not match", expectedPrice, actualPrice);
        Assert.assertEquals("Product quantity in cart does not match", expectedQty, actualQty);
        Assert.assertTrue(checkoutOverviewPage.isCheckoutOverviewPageDisplayed());
        AllureHelper.screenshotToAllure("Checkout Overview", driver);
    }

    /**
     * This method simulates the action of finishing the checkout process and do the price validation.
     */
    @Step("When the user finishes the checkout process")
    @When("the user finishes the checkout process")
    public void finishCheckoutProcess() {
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        String productPriceText = checkoutOverviewPage.getProductPrice();
        String taxText = checkoutOverviewPage.getTaxRaw();
        String totalText = checkoutOverviewPage.getTotalRaw();
        double productPrice = Double.parseDouble(productPriceText.replace("Item total:", "").replace("$", "").trim()
        );
        double tax = Double.parseDouble(
                taxText.replace("Tax:", "").replace("$", "").trim()
        );
        double total = Double.parseDouble(
                totalText.replace("Total:", "").replace("$", "").trim()
        );
        double expectedTotal = productPrice + tax;
        Assert.assertEquals("Checkout total mismatch", expectedTotal, total, 0.01);
        double expectedTax = productPrice * 0.08;
        Assert.assertEquals("Tax mismatch", expectedTax, tax, 0.01);
        AllureHelper.screenshotToAllure("Checkout Finished", driver);
        checkoutOverviewPage.clickFinish();
    }

    /**
     * This method validates that the checkout process has been completed successfully.
     */
    @Step("Then the user should see the confirmation message and go back to the products page")
    @Then("the user should see the confirmation message and go back to the products page")
    public void checkoutCompletedValidation() {
        checkoutCompletePage = new CheckoutCompletedPage(driver);
        String expectedMessage = "Thank you for your order!";
        String actualMessage = checkoutCompletePage.getSuccessMessageText();
        // TC-8 Step 7: Completion page checks
        // Confirm the success header is displayed and message matches the expected
        // text. After clicking Back Home we must return to the Inventory page
        Assert.assertTrue(checkoutCompletePage.isTitleVisible());
        Assert.assertEquals("Checkout confirmation message mismatch", expectedMessage, actualMessage);
        checkoutCompletePage.clickBackHome();
        Assert.assertTrue(productsPage.isInventoryPresent());
        AllureHelper.screenshotToAllure("Back to inventory page", driver);
    }


}
