@regression
@Search
Feature: user should be able to search

  Background: user open browser and go to Search
    And user navigate to search


  #Test Scenario 1
  Scenario: user search
    When user enter valid data to search
    And user click on search button
    #Expected Result
    Then user go to search page
