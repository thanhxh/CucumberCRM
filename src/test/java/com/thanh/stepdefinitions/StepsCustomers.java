package com.thanh.stepdefinitions;

import com.thanh.helpers.ExcelHelpers;
import com.thanh.hooks.TestContext;
import com.thanh.pages.CommonPage;
import com.thanh.pages.CustomersPage;
import com.thanh.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsCustomers {
    public TestContext testContext;
    public LoginPage loginPage;
    public CustomersPage customersPage;
    public CommonPage commonPage;
    ExcelHelpers excelHelpers;

    public StepsCustomers(TestContext testContext) {
        this.testContext = testContext;
        loginPage = testContext.getLoginPage();
        commonPage = testContext.getCommonPage();
    }

    @Given("user on the customer page")
    public void userOnTheCustomerPage() {
        customersPage = commonPage.openCustomersPage();
    }

    @When("user click on the new customer")
    public void userClickOnTheNewCustomer() {
        customersPage.clickNewCustomer();
    }

    @And("user enter the customer information")
    public void userEnterTheCustomerInformation() {
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Customer");
        customersPage.enterInformation(
                excelHelpers.getCellData("nameCompany", 1),
                excelHelpers.getCellData("groups", 1),
                excelHelpers.getCellData("currency", 1),
                excelHelpers.getCellData("languageDefault", 1),
                excelHelpers.getCellData("country", 1)
        );
    }

    @And("user click on Save button")
    public void userClickOnSaveButton() {
        customersPage.clickSaveButton();
    }

    @Then("user checks the information again after add")
    public void userChecksTheInformationAgainAfterAdd() {
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Customer");
        commonPage.openCustomersPage();
        customersPage.searchCustomer(
                excelHelpers.getCellData("nameCompany", 1)
        );
    }

    @When("user enter valid information on search textbox")
    public void userEnterValidInformationOnSearchTextbox() {
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Customer");
        customersPage.searchCustomer(
                excelHelpers.getCellData("nameCompany", 1)
        );
    }

    @And("user click on delete information in table")
    public void userClickOnDeleteInformationInTable() {
        customersPage.clickDeleteButton(1, 3);
    }

    @Then("user confirm delete information in table")
    public void userConfirmDeleteInformationInTable() {
        customersPage.clickConfirmDeleteButton();
    }
}
