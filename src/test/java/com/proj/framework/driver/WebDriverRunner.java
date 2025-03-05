package com.proj.framework.driver;

import com.proj.cucumber.page.HomePage;
import com.proj.framework.config.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverRunner {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriverRunner() {
    }

    public static WebDriver getDriver() {
        if (driver.get() != null) {
            return driver.get();
        }
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver.set(new ChromeDriver(options));
        driver.get().manage().window().maximize();
        return driver.get();
    }

    public static void closeWebDriver(){
        if (driver.get() != null){
            driver.get().manage().deleteAllCookies();
            driver.get().quit();
            driver.remove();
        }
    }
}
