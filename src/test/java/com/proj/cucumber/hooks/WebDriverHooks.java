package com.proj.cucumber.hooks;

import com.proj.cucumber.page.HomePage;
import com.proj.framework.driver.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.proj.framework.driver.WebDriverRunner.getDriver;

public class WebDriverHooks {

    @Before
    public void setupDriver() {
        new HomePage(getDriver()).openPage();
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}

