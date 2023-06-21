Feature: Projects Page

  Background:Login as Admin role
    Given user login page
    Then user logged in with admin role

  @AddProject
  Scenario:Add a new project
    Given user on the projects page
    When user click on new project
    And user enter the project information
    And user click on Save button in project information
    Then user checks the information again of project after add

  @EditProject
  Scenario:Edit a project
    Given user on the projects page
    When user enter valid information of project on search textbox
    And user click on edit information in table
    And user edit the project information
    And user click on Save button edit in project information
    Then user checks the information again of project after edit

  @DeleteCustomer
  Scenario: Delete a project
    Given user on the projects page
    When user enter valid information of project after edit on search textbox
    And user click on delete information of project in table
    Then user confirm delete information of project in table
    And re-search information of project after delete successfully