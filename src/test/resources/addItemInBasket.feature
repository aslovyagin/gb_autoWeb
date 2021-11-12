Feature: add item in basket

  Scenario:
    Given I am at main page
    When I choose category in navigation menu
    And I click on item
    And I add item to basket
    And I confirm adding item to basket
    Then Items in basket contains choosen item
