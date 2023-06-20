Feature: Customers Page

  Background:Login as Admin role
    Given user login page
    Then user logged in with admin role

  @AddCustomer
  Scenario:Add a new customer
    Given user on the customer page
    When user click on the new customer
    And user enter the customer information
    And user click on Save add button
    Then user checks the information again after add

  @EditCustomer
  Scenario:Edit a new customer
    Given user on the customer page
    When user enter valid information on search textbox
    And user click on view information in table
    And user edit the customer information
    And user click on Save edit button
    Then user checks the information again after edit

  @DeleteCustomer
  Scenario: Delete a customer
    Given user on the customer page
    When user enter valid information after edit on search textbox
    And user click on delete information in table
    Then user confirm delete information in table
    And re-search after delete successfully