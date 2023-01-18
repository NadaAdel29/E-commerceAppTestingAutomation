@regression
@Category
Feature: user should be able to see different categoery

  Background: user open browser and go to category
    And user navigate to category


  #Test Scenario 1
  Scenario: different categories
    When choose Category
    And choose subcategory
#    And user click on Category button
    #Expected Result
    Then user go to home page with category