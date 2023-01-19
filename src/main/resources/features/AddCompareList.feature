@regression
@Compare
Feature: user should be able to add product to compare

  Background: user open browser and go to add product compare
    And user navigate to compare


  #Test Scenario 1
  Scenario: Compare
    When choose item Compare
    And user click on item Compare
    And user click on add compare
    #Expected Result
    Then user go to home page message Compare