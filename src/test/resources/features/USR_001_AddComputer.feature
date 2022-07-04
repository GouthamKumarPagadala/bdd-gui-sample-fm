@Gatling @Regression
Feature: To verify add computer
  This feature allows user to add computer details
  @Positive @Smoke
  Scenario: To verify the addition of new computer details
    Given user clicks on add a new computer button
    And User enter new computer with "Valid" details
    When User clicks on create new computer
    Then User verify message displayed with "Done ! Computer {computerName} has been created"

  @Negative
  Scenario: To verify the addition of new computer details without required field
    Given user clicks on add a new computer button
    And User enter new computer with "Empty computerName" details
    When User clicks on create new computer
    Then User verify error message displayed as "Failed to refine type : Predicate isEmpty() did not fail."




