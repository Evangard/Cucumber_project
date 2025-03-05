Feature: Login

  Scenario: Login to the cabinet
    Given User goes to login page
    When User enters email "anton.mikolaenko@gmail.com" and password "TesteR_2025"
    And User clicks on login button
    Then User should be logged in





