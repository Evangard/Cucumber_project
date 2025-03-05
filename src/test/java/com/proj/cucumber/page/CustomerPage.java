package com.proj.cucumber.page;

import com.proj.cucumber.elements.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPage extends GenericPage {

    @FindBy(xpath = "//title[text()='My Account']")
    private WebElement title;

    @FindBy(xpath = "//*[text()='Uitloggen']/ancestor::a")
    private WebElement logoutButton;

    @FindBy(xpath = "//span[text()='Gelukt! Je bent veilig afgemeld.']")
    private WebElement successfulLogoutMessage;

    @FindBy(xpath = "//h2[starts-with( normalize-space(), 'Hallo')]")
    private WebElement greetingLabel;

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    public Button logoutButton() {
        return new Button(logoutButton, "Uitloggen button");
    }

    @Step("Check if customer page opened.")
    public boolean isCustomerPageShown() {
        return tryWaitUntil(() -> title.isEnabled() && greetingLabel.isDisplayed());
    }

    @Step
    public CustomerPage logout() {
        tryWaitUntil(() -> logoutButton.isDisplayed());
        logoutButton().click();
        if (!isCustomerLoggedOut()) {
            throw new IllegalStateException("Customer wasn't logget out.");
        };
        return this;
    }

    @Step
    public boolean isCustomerLoggedOut() {
        return tryWaitUntil(() -> successfulLogoutMessage.isDisplayed());
    }

//    @Override
//    protected void waitUntilLoaded() {
//        isCustomerPageShown();
//    }

    @Override
    public void openPage() {

    }
}
