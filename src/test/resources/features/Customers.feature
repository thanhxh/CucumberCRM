Feature: Customers Page

  Background:Login as Admin role
    Given user login page
    Then user logged in with admin role

  @AddCustomer
  Scenario:Add a new customer
    Given user on the customer page
    When user click on the new customer
    And user enter the customer information
    And user click on Save button add in customer information
    Then user checks the information again of customer after add

  @EditCustomer
  Scenario:Edit a customer
    Given user on the customer page
    When user enter valid information of customer on search textbox
    And user click on view information in table
    And user edit the customer information
    And user click on Save button edit in customer information
    Then user checks the information again of customer after edit

  @DeleteCustomer
  Scenario: Delete a customer
    Given user on the customer page
    When user enter valid information of customer after edit on search textbox
    And user click on delete information of customer in table
    Then user confirm delete information of customer in table
    And re-search information of customer after delete successfully