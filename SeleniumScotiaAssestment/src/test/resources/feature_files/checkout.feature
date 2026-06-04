@Checkout @PositiveFlow
Feature: Complete Checkout Flow

  Scenario Outline: Successful purchase of a product
    Given the user is logged in with "<username>" and "<password>"
    And the cart is empty
    When the user adds "<product>" to the cart
    And proceeds through checkout with shipping details
    And completes the checkout process
    Then the order should be confirmed with total "<total>"
    And the cart should be empty after returning home
    Then the Inventory page should be displayed

    Examples:
      | username       | password     | product              | total   |
      | standard_user  | secret_sauce | Sauce Labs Backpack  | $32.39  |
