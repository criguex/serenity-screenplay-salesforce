Feature: Edit account

  Scenario: Modify an account created
    Given actor is on dashboard accounts
    And Click on edit account
    When The actor edits the form and saves info
    Then the system displays the update info