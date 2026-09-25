Feature: Create a new account

  Scenario: Create account on salesforce page
    Given actor is on the home page
    When goes to account functionality and click on new
    And  actor completes form and saves info
    Then the account is created
    And the system shows the dashboard of the new account