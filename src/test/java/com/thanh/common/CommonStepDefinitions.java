package com.thanh.common;

import com.thanh.hooks.TestContext;
import com.thanh.pages.CommonPage;
import com.thanh.pages.LoginCRMPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CommonStepDefinitions {

    TestContext testContext;
    LoginCRMPage loginCRMPage;

    CommonPage commonPage;

    public CommonStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
        commonPage = testContext.getCommonPage();
        loginCRMPage = testContext.getLoginCRMPage();
    }

    @Given("user login page")
    public void userTheLoginPage() {
        loginCRMPage.gotoLoginPage();
    }


    @And("stay on the login page")
    public void stayOnTheLoginPage() {
    }

}
