Feature: Property search on results page

  Background:
    Given I am on www.hotels.com

  Scenario: Sort results and verify pricing
    When I click search bar
    And I type destination los an
    And I click on Los Angeles suggestion
    And I click on Check In field
    And I select date 15 July 2022
    And I click calendar done button
    And I click on Check Out field
    And I select date 25 July 2022
    And I click calendar done button
    And I click destination search button
    And I enter PPPP in search by property
    Then I verify the No Matches error is displayed on the page
    Then I verify invalid data entered is displayed as one of the filters