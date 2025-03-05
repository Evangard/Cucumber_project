package com.proj.cucumber.page;

import com.proj.cucumber.elements.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends GenericPage {

    @FindBy(xpath = "//div[contains(@class, 'hidden')]/a//span[text()='MyAveve']")
    private WebElement myAveveButton;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptAllCookiesButton;

    @FindBy(xpath = "//title[text()='Home - Aveve - hier groeit plezier']")
    private WebElement title;

    @FindBy(xpath = "//div[@id='desktop-nav']//a[normalize-space()='Tuin']")
    private WebElement tuinTab;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Button myAveveButton() {
        return new Button(myAveveButton);
    }

    public Button acceptAllCookiesButton() {
        return new Button(acceptAllCookiesButton);
    }

    @Override
    public void openPage() {
        driver.get(BASE_PAGE);
        if (tryWaitUntil(() -> acceptAllCookiesButton.isDisplayed(), 5)) {
            acceptAllCookiesButton().click();
        }
    }
}
