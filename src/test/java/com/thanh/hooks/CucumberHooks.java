package com.thanh.hooks;

import com.thanh.driver.DriverManager;
import com.thanh.helpers.PropertiesHelpers;
import com.thanh.utils.LogUtils;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CucumberHooks {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("================ beforeAll ================");
        PropertiesHelpers.loadAllFiles();
        //Khởi chạy Report
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("================ afterAll ================");

    }

    @Before
    public void beforeScenario() {
        System.out.println("================ beforeScenario ================");
        //BaseTest.createDriver();
        //Record video
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("================ afterScenario ================");
        DriverManager.quit();
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        System.out.println("================ beforeStep ================");
        //Ghi file log4j
        LogUtils.info(scenario.getName());
        //Ghi log step vào report
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        System.out.println("================ afterStep ================");
        //validate if scenario has failed then Screenshot
//        if (scenario.isFailed()) {
//            CaptureHelpers.takeScreenshot(scenario.getName());
//        }
        //Chụp lỗi và xuất ra file ảnh trên report
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot Failed");
        }
    }
}
