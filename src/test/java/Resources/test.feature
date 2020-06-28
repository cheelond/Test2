Feature: Demo using Cucumber BDD test steps.

  @Smoketest
  Scenario: This is a basic test
    Given I goto BBC site
    When I select news
    Then I click on sports
    And I see F1 sports

  @Integrationtest
  Scenario: This is a basic test2
    Given I goto BBC site
    When I select news
    Then I click on sports
    And I see F1 sports

  @Smoketest
  @Integrationtest
  Scenario: This is a basic test3
    Given I goto BBC site
    When I select news
    Then I click on sports
    And I see F1 sports

  @Smoketest
  Scenario Outline: This is a basic test4
    Given I goto BBC site with <datatype1> and <datatype2>
    When I select news
    Then I click on sports
    And I see F1 sports

    Examples:
      | datatype1 | datatype2 |
      | david     | wong      |
      | michael   | smith     |

