package com.thanh.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/LoginCRM.feature",
        glue = {
                "com.thanh.stepdefinitions",
                "com.thanh.common",
                "com.thanh.hooks"
        },
        plugin = {
                "com.thanh.hooks.CucumberListener",
                "pretty",
                "html:target/cucumber-reports/TestRunnerLoginCRM.html",
                "json:target/cucumber-reports/TestRunnerLoginCRM.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        tags = ""
)
@Test
public class TestRunnerLoginCRM extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}

