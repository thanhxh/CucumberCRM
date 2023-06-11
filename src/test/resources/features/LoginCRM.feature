Feature: Login to CRM
  As a user, I want to be able to log into the CRM system
  So that I can manage customer information

  Example: Successful login
    Given user the login page
    When user enter valid username and password
    And  user click the Login button
    Then user should be redirected to the dashboard page
    And  user should see the "Customers" menu
    And  user should see the notification displays