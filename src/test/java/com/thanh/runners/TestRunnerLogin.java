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
                "html:target/cucumber-reports/TestRunnerLogin.html",
                "json:target/cucumber-reports/TestRunnerLogin.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        tags = ""
)
@Test
public class TestRunnerLogin extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}

