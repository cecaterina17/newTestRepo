Feature: Feedback Form Verification

  Background:
    Given I am on www.hotels.com
    When I click on sign in field
    And I click on feedback link

  @Sprint-1 @TC-24
  Scenario: Verify empty form submission gives error
    And I click on feedback submit button
    Then I verify empty form submission error is displayed
    Then I verify red dotted border around star rating section
    And I quit browser