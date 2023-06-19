Feature: Customers Page

  Background:Login as Admin role
    Given user login page
    Then user logged in with admin role

  @AddCustomer
  Scenario:Add a new customer
    Given user on the customer page
    When user click on the new customer
    And user enter the customer information
    And user click on Save button
    Then user checks the information again after add

  @DeleteCustomer
  Scenario: Delete a customer
    Given user on the customer page
    When user enter valid information on search textbox
    And user click on delete information in table
    Then user confirm delete information in table
    And re-search after delete successfull