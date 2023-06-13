package com.thanh.hooks;

import com.thanh.driver.DriverFactory;
import com.thanh.pages.CommonPage;
import com.thanh.pages.LoginPage;
import com.thanh.utils.LogUtils;
import org.openqa.selenium.support.ThreadGuard;

import static com.thanh.driver.DriverManager.getDriver;

public class TestContext {
    private CommonPage commonPage;
    private LoginPage loginPage;

    public TestContext() {
        ThreadGuard.protect(new DriverFactory().createDriver());
        LogUtils.info("Driver in TestContext: " + getDriver());
    }

    public CommonPage getCommonPage() {
        if (commonPage == null) {
            commonPage = new CommonPage();
        }
        return commonPage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }


}
