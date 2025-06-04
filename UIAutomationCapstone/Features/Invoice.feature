Feature: Swap Labs testing for the final invoice
  The feature allows users to add products to the cart, proceed to checkout, and complete the payment.

  @execute
  Scenario: User adds products to the cart and proceeds to checkout without entering the first name
    Given User is already logged in and navigated to the product page
    When  User selects the desired products and adds them to the cart
    And  User clicks on the Cart button
    Then User should navigate to the your cart page and see all the selected products
    When User clicks the Checkout button
    Then  User should be navigated to the checkout information page
    And  User enters all the required data except for the first name and clicks on the CONTINUE button
    Then Error: First Name is required message should be displayed on screeen

  @execute
  Scenario: User adds products to the cart and proceeds to checkout without entering the last name
    Given User is already logged in and navigated to the product page
    When  User selects the desired products and adds them to the cart
    And  User clicks on the Cart button
    Then User should navigate to the your cart page and see all the selected products
    When  User clicks the Checkout button
    Then  User should be navigated to the checkout information page
    And  User enters all the required data except for the last name and clicks on the CONTINUE button
    Then Error: Last Name is required message should be displayed on screen

  @execute
  Scenario: User adds products to the cart and proceeds to checkout without entering the postal code
    Given User is already logged in and navigated to the product page
    When  User selects the desired products and adds them to the cart
    And  User clicks on the Cart button
    Then User should navigate to the your cart page and see all the selected products
    When  User clicks the Checkout button
    Then  User should be navigated to the checkout information page
    And  User enters all the required data except for the postal code and clicks on the CONTINUE button
    Then Error: Postal Code is required message should be displayed on screen


  @execute
  Scenario: User adds products to the cart, proceeds through checkout, and completes payment
    Given  User is already logged in and navigated to the product page
    When  User selects the desired products and adds them to the cart
    And  User clicks on the Cart button
    Then  User should navigate to the your cart page and see all the selected products
    When  User clicks the Checkout button
    Then  User should be navigated to the checkout information page
    And  User enters the following details and clicks on the CONTINUE button
      | firstName | lastName | postalCode |
      | Shaik    | Firoz  | 601301     |
    Then  User should navigate to the checkout overview page
    When  User captures the SauceCard and total amount
    And   User clicks the FINISH button
    Then  User should be navigated to the order completion page


