@CompleteTest @RetailHomePageFeatureCompleteTest
Feature: This feature is use for testing UI of Retail page

  Background: 
    Given User is on retail website

  @RetailHomePageFeatureScenario1Test
  Scenario: Verify user can search a product
    When User search for "pokemon" product
    Then The product should be displayed

  @RetailHomePageFeatureScenario2Test
  Scenario: Verify Shop by Department sidebar
    When User click on All section
    Then below options are present in Shop by Department sidebar
      | Electronics | Computers | Smart Home | Sports | Automative |

  @RetailHomePageFeatureScenario3Test
  Scenario Outline: Verify department sidebar options
    When User click on All section
    And User on '<department>'
    Then below options are present in department
      | <optionOne> | <optionTwo> |

    Examples: 
      | department  | optionOne                      | optionTwo                |
      | Electronics | TV & Video                     | Video Games              |
      | Computers   | Accessories                    | Networking               |
      | Smart Home  | Smart Home Lightning           | Plugs and Outlets        |
      | Sports      | Athletic Clothing              | Exercise & Fitness       |
      | Automative  | Automative Parts & Accessories | MotorCycle & Powersports |
