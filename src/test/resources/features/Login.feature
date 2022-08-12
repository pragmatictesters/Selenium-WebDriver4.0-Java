Feature: Login to PTL HRM system


  @smoke
  Scenario: Login with valid credentials
    Given User has accessed the login page
    When Uer type username "Admin"
    And Type password "Ptl@#321"
    And Click login button
    Then Use should see welcome message "Welcome Admin"

  @regression
  Scenario: Login with invalid password
    Given User has accessed the login page
    When Uer type username "Admin"
    And Type password "Password"
    And Click login button
    Then Use should get an error message "Invalid credentials"

  @regression
  Scenario: Login with blank username
    Given User has accessed the login page
    When Uer type username ""
    And Type password "Password"
    And Click login button
    Then Use should get an error message "Username cannot be empty"

