package com.thanh.stepdefinitions;

import com.thanh.helpers.ExcelHelpers;
import com.thanh.hooks.TestContext;
import com.thanh.pages.CommonPage;
import com.thanh.pages.LoginPage;
import com.thanh.pages.ProjectsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsProjects {
    private TestContext testContext;
    private LoginPage loginPage;
    private CommonPage commonPage;
    private ProjectsPage projectsPage;
    private ExcelHelpers excelHelpers;

    public StepsProjects(TestContext testContext) {
        this.testContext = testContext;
        loginPage = testContext.getLoginPage();
        commonPage = testContext.getCommonPage();
    }

    @Given("user on the projects page")
    public void userOnTheProjectsPage() {
        projectsPage = commonPage.openProjectsPage();
    }

    @When("user click on new project")
    public void userClickOnNewProject() {
        projectsPage.clickNewProject();
    }

    @And("user enter the project information")
    public void userEnterTheProjectInformation() {
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Project");
        projectsPage.enterProjectInformation(
                excelHelpers.getCellData("nameProject", 1),
                excelHelpers.getCellData("nameCustomer", 1),
                excelHelpers.getCellData("totalRate", 1),
                excelHelpers.getCellData("estimatedHours", 1)
        );
    }

    @And("user click on Save button in project information")
    public void userClickOnSaveButtonInProjectInformation() {
        projectsPage.clickSaveButtonAdd();
    }

    @Then("user checks the information again of project after add")
    public void userChecksTheInformationAgainOfProjectAfterAdd() {
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Project");
        commonPage.openProjectsPage();
        projectsPage.searchProject(
                "In Progress",
                excelHelpers.getCellData("nameProject", 1)
        );
    }
}
