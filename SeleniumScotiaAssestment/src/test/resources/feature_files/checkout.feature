Feature: Complete Checkout Flow

  Scenario Outline: Successful purchase of a product
    Given the user is logged in with "<username>" and "<password>"
    When the user adds first product to the cart
    Then the user should see the product in the cart
    When the user proceeds to checkout and adds the following information:
      | firstName | lastName | postalCode |
      | Juan      | Ramirez  | 12345      |
    Then the user should see the information in the checkout overview page
    When the user finishes the checkout process
    Then the user should see the confirmation message and go back to the products page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
