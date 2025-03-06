package com.proj.cucumber.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        glue = "com.proj.cucumber",
        features = "classpath:io/proj/features"
)
public class CucumberBaseTest extends AbstractTestNGCucumberTests {

}
