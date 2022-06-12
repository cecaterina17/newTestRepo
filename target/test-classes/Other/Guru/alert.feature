Feature: Practice Alerts
  @regression
  Scenario: Click positive btn on alert
    Given I am on Guru landing page
    When I enter the customer id as 100
    And I click on Submit button
    Then I verify 'Customer Successfully Delete!' is displayed