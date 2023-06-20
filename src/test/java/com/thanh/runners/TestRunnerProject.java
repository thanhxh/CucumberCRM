package com.thanh.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/Projects.feature",
        glue = {
                "com.thanh.stepdefinitions",
                "com.thanh.common",
                "com.thanh.hooks"
        },
        plugin = {
                "com.thanh.hooks.CucumberListener",
                "pretty",
                "html:target/cucumber-reports/TestRunnerProject.html",
                "json:target/cucumber-reports/TestRunnerProject.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        tags = ""
)
@Test
public class TestRunnerProject extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
