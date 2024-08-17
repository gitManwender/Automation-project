Feature: Automating 5 Scenario for automationexercise Website

  As a user of the automationexercise website
  scenario 1:one time i want to login with correct email and password
  scenario 2:I want to login with incorrect email and password
  scenario 3:Remove Products From Cart
  scenario 4:Place Order: Login before Checkout
  scenario 5:Logout user


  Background:
    Given I am on the automationexercise Home page and home page is visible

  @LoginWithcorrectCredentials
  Scenario: Successful login with valid credentials
    Given I clicked on SignupLogin button
    And verify 'Login to your account' is visible
    And I have submitted a valid username and Password
    Then Verify that 'Logged in as username' is visible

@LoginWithIncorrectCredentials
  Scenario Outline:  Login User with incorrect email and password
    Given I clicked on SignupLogin button
    And verify 'Login to your account' is visible
    And I have submitted invalid "<username>" and "<password>"
    Then I should see an error message indicating "<errorMessage>"

    Examples:
      | username          | password        | errorMessage                         |
      | invalid@email.com | invalidPassword | Your email or password is incorrect! |
      | abcccc@gmail.com  | validPassword   | Your email or password is incorrect! |
      | valid@email.com   | abccc           | Your email or password is incorrect! |

  @Cross
    Scenario: Remove Products From Cart
      Given I have Add products to cart
      When i clicked on view cart button
      And Verify that cart page is displayed
      Then Click 'X' button corresponding to particular product
      And Verify that empty cart page is displayed

  @PlaceOrderBeforeCheckout
  Scenario: Place Order: Login before Checkout
    Given I clicked on SignupLogin button
    And verify 'Login to your account' is visible
    And I have submitted a valid username and Password
    Then Verify that 'Logged in as username' is visible
    Given I have Add products to cart
    When i clicked on view cart button
    And Verify that cart page is displayed
    Then Click Proceed To Checkout
    And  Verify Address Details and Review Your Order
    And  Enter description in comment text area and click on Place Order
    Then  Enter payment details: Name on Card, Card Number, CVC, Expiration date with following details

      | NameOnCard      | CardNumber  | CVV | ExpirationMonth | ExpirationYear |
      | Manwender Singh | 34554456556 | 456 | 04              | 2024           |
      | Rahul Kumar     | 44555676788 | 566 | 09              | 2024           |
      | David Bekham    | 56901324567 | 789 | 56              | 1026           |

    And Click Pay and Confirm Order button
    Then Verify success message Your order has been placed successfully

    @LogoutUser
  Scenario: Logout User
    Given I clicked on SignupLogin button
    And verify 'Login to your account' is visible
    And I have submitted a valid username and Password
    Then Verify that 'Logged in as username' is visible
    Then click on Logout Button
    And  verify 'Login to your account' is visible

  @DDTThroughXl
  Scenario: Register User
    Given I clicked on SignupLogin button
    Then Verify New User Signup! is visible
    Then I filled all the necessary details to To create a Account and click create Account button
    Then Verify that ACCOUNT CREATED! is visible
    And  Click on Continue button
    Then Verify that 'Logged in as username' is visible
    Then I Click Delete Account button
    And Verify that that ACCOUNT DELETED! is visible
    And  Click on Continue button

    @DownloadInvoiceAfterPurchace
  Scenario: DownloadInvoiceAfterPurchace
    Given I have Add products to cart
    When i clicked on view cart button
    And Verify that cart page is displayed
    Then Click Proceed To Checkout
    Then Click Register Login button
    Then I  Fill all details in Signup and create account
    Then Verify that ACCOUNT CREATED! is visible
    And  Click on Continue button
    Then Verify that 'Logged in as username' is visible
    Then Click Cart button
    Then Click Proceed To Checkout
    And  Verify Address Details and Review Your Order
    And  Enter description in comment text area and click on Place Order
    Then  Enter payment details: Name on Card, Card Number, CVC, Expiration date with following details

      | NameOnCard      | CardNumber  | CVV | ExpirationMonth | ExpirationYear |
      | Manwender Singh | 34554456556 | 456 | 04              | 2024           |

    And Click Pay and Confirm Order button
    Then Verify success message Your order has been placed successfully
    Then  Click Download Invoice button and verify invoice is downloaded successfully
    And  Click on Continue button
    Then I Click Delete Account button
    And Verify that that ACCOUNT DELETED! is visible
    And  Click on Continue button