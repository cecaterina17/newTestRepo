Feature: Lowest price hotel automation

  Background:
    Given I am on www.hotels.com

  Scenario: Sort results and verify pricing
    When I click search bar
    And I type destination Orla
    And I click on Orlando from destination suggestion
    And I click on Check In field
    And I select date 21 June 2022
    And I click calendar done button
    And I click on Check Out field
    And I select date 25 June 2022
    And I click calendar done button
    And I click destination search button
    Then I verify all popular filters are unchecked
    And I sort the search results using price
    Then I verify lowest price is less then or equal to $100
    And I quit browser