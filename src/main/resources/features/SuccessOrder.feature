@regression
@Order
Feature: user should be able to add product to Card

  Background: user open browser and go to add product
    And user navigate to order


  #Test Scenario 1
  Scenario: Order
    When choose item Order
    And user click on item Order
#    And user click on add Order
    And click on card
    And click on terms
    And click on checkout
    #Expected Result
    Then user go to home page message Order
    #https://demo.nopcommerce.com/cart