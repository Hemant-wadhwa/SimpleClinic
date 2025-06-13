Feature: User Login

  Scenario: Successful login
    Given User is on the login page
    When User enters username "Admin" and password "admin123"
    And Clicks on the login button
    Then User should be logged in successfully