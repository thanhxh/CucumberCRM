package com.thanh.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/Customers.feature",
        glue = {
                "com.thanh.stepdefinitions",
                "com.thanh.common",
                "com.thanh.hooks"
        },
        plugin = {
                "com.thanh.hooks.CucumberListener",
                "pretty",
                "html:target/cucumber-reports/TestRunnerCustomer.html",
                "json:target/cucumber-reports/TestRunnerCustomer.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        tags = "@AddCustomer"
)
@Test
public class TestRunnerCustomer extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
