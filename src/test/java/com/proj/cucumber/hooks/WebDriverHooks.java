package com.proj.cucumber.hooks;

import com.proj.cucumber.page.HomePage;
import com.proj.framework.driver.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.proj.framework.driver.WebDriverRunner.getDriver;

public class WebDriverHooks {

    @Before
    public void setupDriver() {
        new HomePage(getDriver()).openPage();
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
                Allure.addAttachment(screenshot.getName(), new FileInputStream(screenshot));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        WebDriverRunner.closeWebDriver();
    }
}

