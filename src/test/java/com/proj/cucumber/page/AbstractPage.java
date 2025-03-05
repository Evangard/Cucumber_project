package com.proj.cucumber.page;

import com.proj.framework.WaitUtil;
import com.proj.framework.config.TestConfig;
import com.proj.framework.tools.AdditionalConditions;
import com.proj.framework.tools.WebElementUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.function.Supplier;

public abstract class AbstractPage {
    protected final String BASE_PAGE = TestConfig.CONFIG.baseUrl();
    private WebElementUtils webElementUtils;
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    protected boolean waitUntil(Supplier<Boolean> condition) {
        return WaitUtil.getWebDriverWait().until(AdditionalConditions.isTrue(condition));
    }

    protected boolean waitUntil(Supplier<Boolean> condition, int seconds) {
        return WaitUtil.getWebDriverWait(seconds).until(AdditionalConditions.isTrue(condition));
    }

    protected boolean tryWaitUntil(Supplier<Boolean> condition) {
        try {
            return waitUntil(condition);
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected boolean tryWaitUntil(Supplier<Boolean> condition, int seconds) {
        try {
            return waitUntil(condition, seconds);
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected WebElementUtils webElementUtils() {
        return webElementUtils != null ? webElementUtils : WebElementUtils.getInstance();
    }

    public abstract void openPage();
}
