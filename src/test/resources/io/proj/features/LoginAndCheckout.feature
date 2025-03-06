Feature: Login

  Scenario: Login to Aveve
    Given User goes to login page
    When User enters credentials
    And User clicks on login button
    Then User should be logged in


  Scenario: Add product to basket
    Given User goes to home page
    When User opens "Dier" tab
    And User select "Hond" category
    And User adds "Droogvoer voor volwassen honden van grote rassen" item to cart
    And User clicks on To order button
    Then Cart should be opened
    And Chosen "Droogvoer voor volwassen honden van grote rassen" item is shown
