Feature: Verify Scroll Functionality

  Scenario: Verify scroll functionality in tutorial tab
    Given I am on the ReactJS site
    When I click on the Tutorial Tab
    Then the user scrolls down in the tutorial tab
    And the respected content is bolded on the right navigation and blue color line is seen