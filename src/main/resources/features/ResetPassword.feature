@Reset

Feature: user should be able to reset his password

  Background: user open browser and go to forget password
    And user navigate to Reset Password Page


  #Test Scenario 1
  Scenario: user Reset his password by email
    When user enter valid Email
    And user click on Recover

