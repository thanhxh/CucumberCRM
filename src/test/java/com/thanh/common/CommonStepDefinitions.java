package com.thanh.common;

import com.thanh.hooks.TestContext;
import com.thanh.pages.CommonPage;
import com.thanh.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CommonStepDefinitions {

    TestContext testContext;
    LoginPage loginPage;

    CommonPage commonPage;

    public CommonStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
        commonPage = testContext.getCommonPage();
        loginPage = testContext.getLoginPage();
    }

    @Given("user login page")
    public void userTheLoginPage() {
        loginPage.gotoLoginPage();
    }


    @And("stay on the login page")
    public void stayOnTheLoginPage() {
    }

}
