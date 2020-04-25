Feature: Product search

  Scenario: Execute a product search
    Given I am on the home page
    Then I enter and search an item name in the search field
    And The matching results will be displayed