Feature: Testing ReactJS Docs Tabs
@test1
  Scenario: Navigate to Docs Tab and extract sub elements
    Given I am on the ReactJS site
    When I click on the Docs Tab
    Then I expand the main Concepts and extract all sub elements
    And I save the extracted text in a file
@test2
  Scenario: Navigate to Advanced Guides Tab and extract sub elements
    Given I am on the ReactJS site
    When I click on the Docs Tab
    Then I expand the Advanced Guides and extract all sub elements
    And I save the extracted text for Advanced Guides in a file
    
    
