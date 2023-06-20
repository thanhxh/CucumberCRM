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