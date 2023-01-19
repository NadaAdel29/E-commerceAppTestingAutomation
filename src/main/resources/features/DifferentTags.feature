@regression
@Tags
Feature: user should be able to see different Tags

  Background: user open browser and go to Tags
    And user navigate to Tags


  #Test Scenario 1
  Scenario: different Tags
    When choose Tags
  And user click on Tags button
    #Expected Result
    Then user go to home page with Tags