@regression
@Register
Feature: User could register with valid data
  Background: user open browser and go to Register page
    And user navigate to Register Page


  #Test Scenario 1
  Scenario: user Register with valid data
    When user enter valid data
    And user click on Register button
    #Expected Result
    Then user could Register successfully
    And user go to home page
