@regression
@Filter
Feature: user should be able to filter

  Background: user open browser and go to Filter
    And user navigate to filter


  #Test Scenario 1
  Scenario: filter by color
    When choose the color
    And user click on color button
    #Expected Result
    Then user go to home page with filtration