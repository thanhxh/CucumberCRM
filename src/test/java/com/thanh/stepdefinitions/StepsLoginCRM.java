package com.thanh.stepdefinitions;

import com.thanh.constants.ConstantGlobal;
import com.thanh.hooks.TestContext;
import com.thanh.keywords.WebUI;
import com.thanh.pages.LoginCRMPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsLoginCRM {
    LoginCRMPage loginCRMPage;

    public StepsLoginCRM(TestContext testContext) {
        loginCRMPage = testContext.getLoginCRMPage();
    }

    @Given("user the login page")
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
        WebUI.verifyEquals(customerMenu, "Customers", "Can not see menu Customers");
    }

    @And("user should see the notification displays")
    public void userShouldSeeTheNotificationDisplays() {
    }
}
