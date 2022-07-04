@Gatling @Regression
Feature: To verify edit computer details
  This feature allows user to edit the existing computer details
  @Positive @Smoke @Edit
  Scenario Outline: To verify the edit operation of existing computer details
    Given User filter the computer with existing name "<Name>"
    And User fetch the data from search results with name "<Name>"
    And User clicks on existing name "<Name>"
    And User edit company data with "<CompanyName>"
    Then User verify message displayed with "<Message>"
    Examples:
      | Name                    | CompanyName | Message                                         |
      | Meiko Computing Surface | Apple Inc.  | Done ! Computer {computerName} has been updated |


