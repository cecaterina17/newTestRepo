Feature: Verify Darksky Temp Values

  Background:
    Given I am on www.darksky.com

  @timeMachine @smoke
  Scenario: Verify the current date is highlighted in Time Machine's calendar
    When  I click on Time Machine button
    Then I verify that date in Time Machine is correct


  Scenario: Verify same values are displayed in the Today's data
    When I expand today details
    Then I verify displayed temp is equal to temp in details