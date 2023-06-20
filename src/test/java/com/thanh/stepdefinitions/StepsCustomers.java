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
    private TestContext testContext;
    private LoginPage loginPage;
    private CustomersPage customersPage;
    private CommonPage commonPage;
    private ExcelHelpers excelHelpers;

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
//                customersPage.getCompanyName(),
                excelHelpers.getCellData("nameCompany", 1),
                excelHelpers.getCellData("groups", 1),
                excelHelpers.getCellData("currency", 1),
                excelHelpers.getCellData("languageDefault", 1),
                excelHelpers.getCellData("country", 1)
        );
    }

    @And("user click on Save add button")
    public void userClickOnSaveAddButton() {
        customersPage.clickSaveButtonAdd();
    }

    @Then("user checks the information again after add")
    public void userChecksTheInformationAgainAfterAdd() {
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Customer");
        commonPage.openCustomersPage();
        customersPage.searchCustomer(
//                customersPage.getCompanyName()
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

    @And("user click on view information in table")
    public void userClickOnViewInformationInTable() {
        customersPage.clickViewButton(1, 3);
    }

    @And("user edit the customer information")
    public void userEditTheCustomerInformation() {
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Edit Customer");

        customersPage.editInformation(
                excelHelpers.getCellData("nameCompany", 1),
                excelHelpers.getCellData("groups", 1),
                excelHelpers.getCellData("currency", 1),
                excelHelpers.getCellData("languageDefault", 1),
                excelHelpers.getCellData("country", 1)
        );

    }

    @And("user click on Save edit button")
    public void userClickOnSaveEditButton() {
        customersPage.clickSaveButtonEdit();
    }

    @Then("user checks the information again after edit")
    public void userChecksTheInformationAgainAfterEdit() {
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Edit Customer");
        commonPage.openCustomersPage();
        customersPage.searchCustomer(
                excelHelpers.getCellData("nameCompany", 1)
        );
    }

    @And("user click on delete information in table")
    public void userClickOnDeleteInformationInTable() {
        customersPage.clickDeleteButton(1, 3);
    }

    @When("user enter valid information after edit on search textbox")
    public void userEnterValidInformationAfterEditOnSearchTextbox() {
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Edit Customer");
        customersPage.searchCustomer(
                excelHelpers.getCellData("nameCompany", 1)
        );
    }

    @Then("user confirm delete information in table")
    public void userConfirmDeleteInformationInTable() {
        customersPage.clickConfirmDeleteButton();
    }

    @And("re-search after delete successfully")
    public void reSearchAfterDeleteSuccessfully() {
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Edit Customer");
        customersPage.reSearchCustomer(
                excelHelpers.getCellData("nameCompany", 1)
        );
    }


}
