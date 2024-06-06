@positiveNegative
Feature: Positive Negative Feature

  @positive
  Scenario: User want to do login successfully
    Given User have a access login to saucelab with correct data
    And User verify product page
    Then User do logout

  @positive
  Scenario: User want to choose item product to cart
    Given User have a access login to saucelab with correct data
    When User verify product page
    And User choose item product
    And User verify shopping cart badge
    And User click on cart button
    Then User verify cart page

  @positive
  Scenario: User want to remove item product from cart
    Given User have a access login to saucelab with correct data
    When User verify product page
    And User choose item product
    And User verify shopping cart badge
    And User click on cart button
    Then User do removed item product

  @positive
  Scenario: User want to see item product details
    Given User have a access login to saucelab with correct data
    When User verify product page
    And User choose item product by name
    Then User verify item product details

  @positive
  Scenario: User want to filter product by price low to high
    Given User have a access login to saucelab with correct data
    When User verify product page
    Then User do filter by price low to high

  @negative
  Scenario Outline: User want to do failed login
    Given User do login with incorrect <invalidUsername> and <invalidPassword>
    Then User verify error message <type>
    Examples:
      | invalidUsername | invalidPassword | type             |
      |                 |                 |                  |
      | userdummy       | password123     | random           |
      | locked_out_user | secret_sauce    | normal           |
      | 123456@!!&&     | secret_sauce    | specialCharacter |
