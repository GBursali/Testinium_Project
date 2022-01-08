Feature: N11 Smoke Test

  Scenario: Navigation to the Homepage.
    When Navigated to the website
    Then Assert that URL is matching
  Scenario: Navigation to the Login Page
    When Clicked to the Sign In button
    Then Assert that we navigated to the Login Page
  Scenario: Login can be performed
    Given Username data
    And Password data
    When Write the Username to the Username field
    And Write the Password to the Password Field
    And Submit the Login form
    Then Assert that we successfully logged in.
  Scenario: Search box is accessible and performing
    Given Query keyword "Bilgisayar" to search
    When Write the keyword to the field
    And Submit the search button
    And Navigate to the next page
    Then Assert that page is navigated
  Scenario: Basket and product prices are matching
    Given A Random product
    And Product's price
    When Product added to the basket
    And Navigate to the basket
    Then Assert that prices are matching
  Scenario: Quantity can be changed in Basket page
    Given Product quantity in the Basket
    When Quantity increment button is clicked
    Then Quantity is increased
  Scenario: Product removal in Basket page
    When Clicked to the remove button in the product
    Then Assert that basket becomes empty
