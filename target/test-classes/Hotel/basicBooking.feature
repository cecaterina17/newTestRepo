Feature: Booking automation

  Background:
    Given I am on www.hotels.com


  Scenario: Verify destination error displayed if search with no destination
    When I click destination search button
    Then I verify search error is displayed


  Scenario: Verify enter-children's age error
    When I click travelers field
    And I add child travelers
    Then I verify age error is displayed
    When I select children's age
    Then I verify age error is not displayed


  Scenario: Verify numbers of travelers before and after search is same
    When I click search bar
    And I type destination Seatt
    And I click on Seattle suggestion
    And I click on Check In field
    And I select date 18 June 2022
    And I click calendar done button
    And I click travelers field
    And I add child travelers
    And I select children's age
    And I click travelers done button
    And I click destination search button
    Then I verify traveler count is same as before