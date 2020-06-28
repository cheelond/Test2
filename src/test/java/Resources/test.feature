Feature: Demo using Cucumber BDD test steps.

  Scenario: This is a basic test
    Given I goto BBC site
    When I select news
    Then I click on sports
    And I see F1 sports
