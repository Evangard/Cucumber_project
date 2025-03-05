package com.proj.cucumber.page;

import com.proj.framework.tools.enums.Tabs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.proj.framework.WaitUtil.waitForSeconds;
import static com.proj.framework.driver.WebDriverRunner.getDriver;

public abstract class GenericPage extends AbstractPage {

    @FindBy(xpath = "//div[starts-with(@class, 'flex flex-row') and normalize-space()='Loading...']")
    private WebElement spinner;

    protected GenericPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on '{0}' tab.")
    public void openTab(Tabs tab) {
        getDriver().findElement(By.xpath(
                String.format("//div[@id='desktop-nav']//a[normalize-space()='%s']", tab.getName()))).click();
    }

    @Step("Select '{0}' category")
    public void selectCategory(String categoryName) {
        String locator = String.format("//div[starts-with(@class, 'flex flex-wrap')]//a[text()='%s']", categoryName);
        waitUntil(() -> getDriver().findElement(By.xpath(locator)).isDisplayed());
        webElementUtils().clickJS(getDriver().findElement(By.xpath(locator)));
    }

    @Step("Add item to the cart.")
    public void addFirstItemToCart() {
        String locator = "//div[starts-with(@class, 'item product')][2]//button[@title='Add to Cart']";
        waitUntil(() -> getDriver().findElement(By.xpath(locator)).isDisplayed());
        WebElement addToCartButton = getDriver().findElement(By.xpath(locator));
        webElementUtils().scrollIntoElement(addToCartButton);
        waitForSeconds(1);
        webElementUtils().clickJS(addToCartButton);
    }

    public void waitUntilLoadingSpinnerAppear() {
        tryWaitUntil(() -> spinner.isDisplayed());
    }

    public void waitUntilLoadingSpinnerDisappear() {
        tryWaitUntil(() -> !spinner.isDisplayed());
    }

    public void waitSpinner() {
        waitUntilLoadingSpinnerAppear();
        waitUntilLoadingSpinnerDisappear();
    }
}
