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
        projectsPage.clickSaveButton();
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

    @When("user enter valid information of project on search textbox")
    public void userEnterValidInformationOfProjectOnSearchTextbox() {
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Project");
        projectsPage.searchProject(
                "In Progress",
                excelHelpers.getCellData("nameProject", 1)
        );
    }

    @And("user click on edit information in table")
    public void userClickOnEditInformationInTable() {
        projectsPage.clickEditButton(1, 2);
    }

    @And("user edit the project information")
    public void userEditTheProjectInformation() {
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Edit Project");
        projectsPage.editProjectInformation(
                excelHelpers.getCellData("nameProject", 1),
                excelHelpers.getCellData("totalRate", 1),
                excelHelpers.getCellData("estimatedHours", 1)
        );
    }

    @And("user click on Save button edit in project information")
    public void userClickOnSaveButtonEditInProjectInformation() {
        projectsPage.clickSaveButton();
    }

    @Then("user checks the information again of project after edit")
    public void userChecksTheInformationAgainOfProjectAfterEdit() {
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Edit Project");
        commonPage.openProjectsPage();
        projectsPage.searchProject(
                "In Progress",
                excelHelpers.getCellData("nameProject", 1)
        );
    }

    @When("user enter valid information of project after edit on search textbox")
    public void userEnterValidInformationOfProjectAfterEditOnSearchTextbox() {
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Edit Project");
        projectsPage.searchProject(
                "In Progress",
                excelHelpers.getCellData("nameProject", 1)
        );
    }

    @And("user click on delete information of project in table")
    public void userClickOnDeleteInformationOfProjectInTable() {
        commonPage.clickDeleteButton(1, 2);
    }

    @Then("user confirm delete information of project in table")
    public void userConfirmDeleteInformationOfProjectInTable() {
        commonPage.clickConfirmDeleteButton();
    }

    @And("re-search information of project after delete successfully")
    public void reSearchInformationOfProjectAfterDeleteSuccessfully() {
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Edit Project");
        projectsPage.reSearchProject(
                "In Progress",
                excelHelpers.getCellData("nameProject", 1)
        );
    }
}
