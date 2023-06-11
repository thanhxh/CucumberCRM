package com.thanh.stepdefinitions;

import com.thanh.constants.ConstantGlobal;
import com.thanh.hooks.TestContext;
import com.thanh.keywords.WebUI;
import com.thanh.models.Credentials;
import com.thanh.pages.LoginCRMPage;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class StepsLoginCRM {
    LoginCRMPage loginCRMPage;

    public StepsLoginCRM(TestContext testContext) {
        loginCRMPage = testContext.getLoginCRMPage();
    }

    @When("user enter valid username and password")
    public void userEnterValidUsernameAndPassword() {
        loginCRMPage.enterEmailAndPassword(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
    }

    @And("click on the login button")
    public void clickOnTheLoginButton() {
        loginCRMPage.clickLoginButton();
    }

    @Then("user should be redirected to the dashboard page")
    public void userShouldBeRedirectedToTheDashboardPage() {
        loginCRMPage.verifyRedirectToDashboardPage();
    }

    @And("user should see the {string} menu")
    public void userShouldSeeTheMenu(String customerMenu) {
        WebUI.verifyEquals(customerMenu, "Customers", "Impossible to see menu Customers");
    }

    @And("user should see the notification displays")
    public void userShouldSeeTheNotificationDisplays() {
    }

    @DataTableType
    public Credentials credentialsEntryTransformer(Map<String, String> row) {
        return new Credentials(row.get("username"), row.get("password"));
    }

    @When("user enter invalid credentials to login")
    public void userEnterInvalidCredentialsToLogin(List<Credentials> credentials) {
        for (Credentials credential : credentials) {
            String email = credential.getUsername();
            String password = credential.getPassword();

            loginCRMPage.enterEmailAndPassword(email, password);
            loginCRMPage.clickLoginButton();
        }
    }

    @Then("user should see an error message")
    public void userShouldSeeAnErrorMessage() {
        loginCRMPage.verifyErrorMessage();
    }


    @When("user leave the username field empty")
    public void userLeaveTheUsernameFieldEmpty() {
    }

    @And("enter a valid password")
    public void enterAValidPassword() {
        loginCRMPage.enterValidPassword(ConstantGlobal.PASSWORD);
    }


    @Then("user should see an error empty message of username")
    public void userShouldSeeAnErrorEmptyMessageOfUsername() {
        loginCRMPage.verifyEmptyMessageEmail();
    }

    @When("user leave the password field empty")
    public void userLeaveThePasswordFieldEmpty() {
    }

    @And("enter a valid username")
    public void enterAValidUsername() {
        loginCRMPage.enterValidUsername(ConstantGlobal.USERNAME);
    }

    @Then("user should see an error empty message of password")
    public void userShouldSeeAnErrorEmptyMessageOfPassword() {
        loginCRMPage.verifyEmptyMessagePassword();
    }

    @And("user have forgotten their password")
    public void userHaveForgottenMyPassword() {
    }

    @When("user click on the {string} link")
    public void userClickOnTheLink(String buttonForgotPassword) {
        loginCRMPage.clickForgotPasswordButton();
        WebUI.verifyEquals(buttonForgotPassword, "Forgot Password?");
    }

    
    @And("enter email address")
    public void enterEmailAddress() {
        loginCRMPage.enterValidUsername(ConstantGlobal.USERNAME);
    }

    @And("click on the {string} button")
    public void clickOnTheButton(String confirm) {
        loginCRMPage.clickConfirmButton();
    }

    @Then("user should receive an email with instructions to reset my password.")
    public void userShouldReceiveAnEmailWithInstructionsToResetMyPassword() {
    }


}
