@regression
@Card
Feature: user should be able to add product to Card

  Background: user open browser and go to add product
    And user navigate to Card


  #Test Scenario 1
  Scenario: Card
    When choose item card
    And user click on item card
    And user click on add card
    #Expected Result
    Then user go to home page message card