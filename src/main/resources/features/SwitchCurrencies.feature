@regression
@Switch
Feature: user should be able to switch

  Background: user open browser and go to switch
    And user navigate to switch


  #Test Scenario 1
  Scenario: switch currencies
    When switch the currencies
    And user click on currency button
    #Expected Result
    Then user go to home page with switch