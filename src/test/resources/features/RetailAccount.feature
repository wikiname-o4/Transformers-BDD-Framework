@CompleteTest @RetailAccountFeatureCompleteTest
Feature: Retail Application Account Feature

  Background: 
    Given User is on retail website
    When User click on Sing in option
    And User enter email 'luqmon.hakim@gmail.com' and password 'Lukas001'
    And User click on login button
    And User should be logged in into Account

  @RetailAccountFeatureScenario1SmokeTest
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'Luqmon' and Phone '7077777777'
    And User click on Update Button
    Then User profile information should be updated

  @RetailAccountFeatureScenario2SmokeTest
  Scenario: Verify User can Update password
    When User click on Account option
    And User enter below information
      | previousPassword | newPassword | confirmPassword |
      | Lukas001         | Lukas001    | Lukas001        |
    And User click on Change Password button
    Then a message should be displayed 'Password Updated Successfully'
