@RetailAccountFeatureScenario2SmokeTest @RetailAccountFeatureCompleteTest
Feature: Retail Application Account PAss Feature

  Scenario Outline: Verify User can Update password
    Given User is on retail website
    When User click on Sing in option
    And User enter email 'luqmon.hakim@gmail.com' and password '<previousPassword>'
    And User click on login button
    And User should be logged in into Account
    When User click on Account option
    And User enter below information
      | previousPassword   | newPassword   | confirmPassword   |
      | <previousPassword> | <newPassword> | <confirmPassword> |
    And User click on Change Password button
    Then a message should be displayed 'Password Updated Successfully'

    Examples: 
      | previousPassword | newPassword | confirmPassword |
      | Lukas002@        | Lukas001@   | Lukas001@       |
      | Lukas001@        | Lukas002@   | Lukas002@       |
