package com.thanh.stepdefinitions;

import com.thanh.constants.ConstantGlobal;
import com.thanh.hooks.TestContext;
import com.thanh.keywords.WebUI;
import com.thanh.models.Credentials;
import com.thanh.pages.LoginCRMPage;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class StepsLoginCRM {
    LoginCRMPage loginCRMPage;

    public StepsLoginCRM(TestContext testContext) {
        loginCRMPage = testContext.getLoginCRMPage();
    }

    @Given("user login page")
    public void userTheLoginPage() {
        loginCRMPage.gotoLoginPage();
    }

    @When("user enter valid username and password")
    public void userEnterValidUsernameAndPassword() {
        loginCRMPage.enterEmailAndPassword(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
    }

    @And("user click the Login button")
    public void userClickTheLoginButton() {
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

    @And("stay on the login page")
    public void stayOnTheLoginPage() {
    }
}
