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

  @RetailHomePageFeatureScenario4Test
  Scenario: Verify User can add an item to cart
    When User click on Sing in option
    And User enter email 'luqmon.hakim@gmail.com' and password 'Lukas002@'
    And User click on login button
    And User should be logged in into Account
    And User change the category to 'Smart Home'
    And User search for an item 'Kasa Outdoor Smart Plug'
    And User click on Search icon
    And User click on item
    And User select quantity '2'
    And User click add to Cart button
    Then the cart icon quantity should change to '2'

  @RetailHomePageFeatureScenario5Test
  Scenario: Verify User can place an order without Shipping address and payment Method on file
    When User click on Sing in option
    And User enter email 'luqmon.hakim@gmail.com' and password 'Lukas002@'
    And User click on login button
    And User should be logged in into Account
    And User change the category to 'Smart Home'
    And User search for an item 'Kasa Outdoor Smart Plug'
    And User click on Search icon
    And User click on item
    And User select quantity '2'
    And User click add to Cart button
    Then the cart icon quantity should change to '2'
    And User click on Cart option
    And User click on Proceed to Checkout button
    And User click Add a new address link for shipping address
    And user fill new address form with below information
      | country       | fullName     | phoneNumber | streetAddress | apt | city       | state    | zipCode |
      | United States | Luqmon Hakim | 58640239889 | 2002 D Street |   2 | Southfield | Michigan |   48075 |
    And User click Add Your Address button
    And User click Add a Credit or Debit Card for Payment method
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard      | expirationMonth | expirationYear | securityCode |
      | 4647634817091108 | Stephon Wiegand |               7 |           2023 |          677 |
    And User click on Add your card button
    And User click on Place Your Order
    Then a message should be displayed 'Order Placed Successfully'

  @RetailHomePageFeatureScenario6Test
  Scenario: Verify User can place an order with Shipping address and payment Method on file
    When User click on Sing in option
    And User enter email 'luqmon.hakim@gmail.com' and password 'Lukas002@'
    And User click on login button
    And User should be logged in into Account
    And User change the category to 'Electronics'
    And User search for an item 'Apex Legends'
    And User click on Search icon
    And User click on item
    And User select quantity '5'
    And User click add to Cart button
    Then the cart icon quantity should change to '5'
    And User click on Cart option
    And User click on Proceed to Checkout button
    And User click on Place Your Order
    Then a message should be displayed 'Order Placed Successfully'
