@regression
@Selenium
Feature: user should be able to login to the system

  Background: user open browser and go to login page
    And user navigate to login page


  #Test Scenario 1
  Scenario: user login with valid username and password
    When user enter valid data login
    And user click on login button
    #Expected Result
    Then user go to home page login
