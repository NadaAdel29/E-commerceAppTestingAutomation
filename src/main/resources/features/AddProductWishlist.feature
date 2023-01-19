@regression
@Wishlist
Feature: user should be able to add product to wishlist

  Background: user open browser and go to add product
    And user navigate to wishlist


  #Test Scenario 1
  Scenario: wishlist
    When choose item
    And user click on item
    And user click on add
    #Expected Result
    Then user go to home page message