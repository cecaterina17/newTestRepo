Feature: Sign In Menu Verification

  Background:
    Given I am on www.hotels.com
    When I click on sign in field

  @Sprint-1 @TC-21
  Scenario: SignIn automation
    And I click on sign in button
    And I enter email in sign in form
    And I enter password in sign in form
    And I check sign in checkbox
    And I click sign in button
    Then I verify sign in error is displayed
    And I quit browser

