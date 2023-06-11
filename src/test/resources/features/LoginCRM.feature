Feature: Login to CRM
  As a user, I want to be able to log into the CRM system
  So that I can manage customer information

  @ValidLogin
  Example: Successful login
    Given user login page
    When user enter valid username and password
    And  user click the Login button
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