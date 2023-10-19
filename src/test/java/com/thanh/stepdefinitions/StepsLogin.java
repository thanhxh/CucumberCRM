package com.thanh.stepdefinitions;

import com.thanh.constants.ConstantGlobal;
import com.thanh.hooks.TestContext;
import com.thanh.keywords.WebUI;
import com.thanh.models.Credentials;
import com.thanh.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class StepsLogin {
    private LoginPage loginPage;

    public StepsLogin(TestContext testContext) {
        loginPage = testContext.getLoginPage();
    }

    @When("user enter valid username and password")
    public void userEnterValidUsernameAndPassword() {
        loginPage.enterEmailAndPassword(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
    }

    @And("click on the login button")
    public void clickOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("user should be redirected to the dashboard page")
    public void userShouldBeRedirectedToTheDashboardPage() {
        loginPage.verifyRedirectToDashboardPage();
    }

    @And("user should see the {string} menu")
    public void userShouldSeeTheMenu(String customerMenu) {
        WebUI.verifyEquals(customerMenu, "Customers", "Impossible to see menu Customers");
    }

    @And("user should see the notification displays")
    public void userShouldSeeTheNotificationDisplays() {
    }

//    @DataTableType
//    public Credentials credentialsEntryTransformer(Map<String, String> row) {
//        return new Credentials(row.get("username"), row.get("password"));
//    }
//
//    @When("user enter invalid credentials to login")
//    public void userEnterInvalidCredentialsToLogin(List<Credentials> credentials) {
//        for (Credentials credential : credentials) {
//            String email = credential.getUsername();
//            String password = credential.getPassword();
//
//            loginPage.enterEmailAndPassword(email, password);
//            loginPage.clickLoginButton();
//        }
//    }
    @When("user enter invalid credentials to login")
    public void userEnterInvalidCredentialsToLogin(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps();
        for (Map<String, String> item : data) {
            String email = item.get("username");
            String password = item.get("password");
            loginPage.enterEmailAndPassword(email, password);
            loginPage.clickLoginButton();
        }
    }


    @Then("user should see an error message")
    public void userShouldSeeAnErrorMessage() {
        loginPage.verifyErrorMessage();
    }


    @When("user leave the username field empty")
    public void userLeaveTheUsernameFieldEmpty() {
    }

    @And("enter a valid password")
    public void enterAValidPassword() {
        loginPage.enterValidPassword(ConstantGlobal.PASSWORD);
    }


    @Then("user should see an error empty message of username")
    public void userShouldSeeAnErrorEmptyMessageOfUsername() {
        loginPage.verifyEmptyMessageEmail();
    }

    @When("user leave the password field empty")
    public void userLeaveThePasswordFieldEmpty() {
    }

    @And("enter a valid username")
    public void enterAValidUsername() {
        loginPage.enterValidUsername(ConstantGlobal.USERNAME);
    }

    @Then("user should see an error empty message of password")
    public void userShouldSeeAnErrorEmptyMessageOfPassword() {
        loginPage.verifyEmptyMessagePassword();
    }

    @And("user have forgotten their password")
    public void userHaveForgottenMyPassword() {
    }

    @When("user click on the forgot password link")
    public void userClickOnTheForgotPasswordLink() {
        loginPage.clickForgotPasswordButton();
    }


    @And("enter email address")
    public void enterEmailAddress() {
        loginPage.enterValidUsername(ConstantGlobal.USERNAME);
    }

    @And("click on the confirm button")
    public void clickOnTheConfirmButton() {
        loginPage.clickConfirmButton();
    }

    @And("message is displayed")
    public void messageIsDisplayed() {
        loginPage.verifyMessageForgotPassword();
    }


    @Then("user should receive an email with instructions to reset my password.")
    public void userShouldReceiveAnEmailWithInstructionsToResetMyPassword() {
    }


}
