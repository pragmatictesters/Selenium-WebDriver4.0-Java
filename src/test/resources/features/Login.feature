Feature: Login to PTL HRM system


  Scenario: Login with invalid password
    Given User has accessed the login page
    When Uer type username "Admin"
    And Type password "Password"
    And Click login button
    Then Use should get an error message "Invalid credentials"

