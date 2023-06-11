Feature: Login to CRM
  As a user, I want to be able to log into the CRM system
  So that I can manage customer information

  @ValidLogin
  Example: Successful login
    Given user login page
    When user enter valid username and password
    And  click on the login button
    Then user should be redirected to the dashboard page
    And  user should see the "Customers" menu
    And  user should see the notification displays

  @InvalidLoginMultiple
  Scenario: Invalid Login with multiple account
    Given user login page
    When user enter invalid credentials to login
      | username          | password |
      | user@example.com  | 123456   |
      | admin@example.com | 123      |
      | user@example.com  | 123      |
    Then user should see an error message
    And stay on the login page

  Scenario: Empty Username
    Given user login page
    When user leave the username field empty
    And enter a valid password
    And click on the login button
    Then user should see an error empty message of username
    And stay on the login page

  Scenario: Empty Password
    Given user login page
    When user leave the password field empty
    And enter a valid username
    And click on the login button
    Then user should see an error empty message of password
    And stay on the login page

  Scenario: Empty Username and Password
    Given user login page
    When user leave the username field empty
    And user leave the password field empty
    And click on the login button
    Then user should see an error empty message of username and password
    And stay on the login page

  Scenario: Forgotten Password
    Given user login page
    And user have forgotten their password
    When user click on the "Forgot Password?" link
    And enter email address
    And click on the "Confirm" button
    Then user should receive an email with instructions to reset my password.