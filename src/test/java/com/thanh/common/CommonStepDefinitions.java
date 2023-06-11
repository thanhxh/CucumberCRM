package com.thanh.common;

import com.thanh.hooks.TestContext;
import com.thanh.pages.CommonPage;
import com.thanh.pages.LoginCRMPage;

public class CommonStepDefinitions {

    TestContext testContext;
    LoginCRMPage loginCRMPage;

    CommonPage commonPage;

    public CommonStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
        commonPage = testContext.getCommonPage();
        loginCRMPage = testContext.getLoginCRMPage();
    }


}
