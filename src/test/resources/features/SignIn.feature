@CompleteTest @SignInFeatureTest
Feature: TEK Retail Application SignIn feature

  Background: 
    Given User is on retail website
    When User click on Sing in option

  @smokeTest
  Scenario: Verify user can sign in into Retail Application
    And User enter email 'luqmon.hakim@gmail.com' and password 'Lukas002@'
    And User click on login button
    Then User should be logged in into Account

  @smokeTestOutline
  Scenario Outline: Verify user can sign in into Retail Application
    And User enter email '<email>' and password '<password>'
    And User click on login button
    Then User should be logged in into Account

    Examples: 
      | email                  | password   |
      | mytest21@gmail.com     | Test@12345 |
      | luqmon.hakim@gmail.com | Lukas002@  |

  @smokeTestCreateAccountScenario
  Scenario: Verufy user can create an account into Retail website
    And User click on Create New Account button
    # Use keyword testData for new email every test
    And User fill the signUp information with below data
      | name  | email    | password  | confirmPassword |
      | Tests | testData | Tek@12345 | Tek@12345       |
    And User click on SignUp button
    Then User should be logged into account page
