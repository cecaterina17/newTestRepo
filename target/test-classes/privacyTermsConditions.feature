Feature: Privacy, Terms & Conditions Verification

  Background:
    Given I am on www.hotels.com
    When I click on sign in field

  @Sprint-1 @TC-20
  Scenario: Verify privacy page link loads correct page
    And I click on sign up button
    And I click on privacy page link
    Then I verify that link opened privacy page
    And I close privacy page
    And I click on terms and conditions page link
    Then I verify that it is a correct page
    And I quit browser