Feature: Facebook footer links

  Scenario: Open and close certain links except Instagram
    Given I am on www.facebook.com
    When I click on Facebook Pay, Oculus, Instagram, Portal and Bulletin
    And I close all tabs except Instagram
    Then I verify number of window-Handles is 1
    And I verify Page Title is Instagram
    Then I verify Login button on Instagram is disabled by default