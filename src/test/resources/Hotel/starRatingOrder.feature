Feature: Star Rating Filter

  Background:
    Given I am on www.hotels.com
  @star
  Scenario: Check star rating order
    When I click search bar
    And I type destination Orla
    And I click on Orlando suggestion
    And I click on Check In field
    And I select date 21 June 2022
    And I click calendar done button
    And I click destination search button
    Then I verify Star rating is displayed in increasing order