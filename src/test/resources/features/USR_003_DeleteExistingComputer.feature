@Gatling @Regression
Feature: To verify delete computer details
  This feature allows user to delete the existing computer details
  @Positive @Smoke @Delete
  Scenario Outline: To verify the delete operation of existing computer details
    Given User filter the computer with existing name "<Name>"
    And User fetch the data from search results with name "<Name>"
    And User clicks on existing name "<Name>"
    And User clicks on delete button
    Then User verify message displayed with "<Message>"
    Examples:
      | Name               | Message                                         |
      | ASCI Blue Mountain | Done ! Computer {computerName} has been deleted |

