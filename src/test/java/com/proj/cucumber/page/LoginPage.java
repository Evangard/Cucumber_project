package com.proj.cucumber.page;

import com.proj.cucumber.elements.Button;
import com.proj.cucumber.elements.Input;
import com.proj.cucumber.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends GenericPage {

    @FindBy(id = "email-address")
    private WebElement emailAddressField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//h1[normalize-space()='Aanmelden']")
    private WebElement registerLabel;

    @FindBy(xpath = "//div[text()='Combinatie van e-mail en wachtwoord wordt niet herkend']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public Input emailAddressField() {
        return new Input(emailAddressField, "E-mailadres field");
    }

    public Input passwordField() {
        return new Input(passwordField, "Wachtwoord field");
    }

    public Button submitButton() {
        return new Button(submitButton, "Aanmelden button");
    }

    public Label registerLabel() {
        return new Label(registerLabel, "Aanmelden label");
    }

    @Step
    public void clickSubmitButton() {
        submitButton().click();
    }

    @Step("Enter '{0}' email")
    public void setEmail(String email) {
        emailAddressField().clearAndType(email);
    }

    @Step("Enter '{0}' password")
    public void setPassword(String password) {
        passwordField().clearAndType(password);
    }

    @Step("Check if error message is displayed.")
    public boolean isErrorMessageShown() {
        return tryWaitUntil(() -> errorMessage.isDisplayed());
    }

//    @Override
//    protected void waitUntilLoaded() {
//        waitUntil(() -> registerLabel.isDisplayed());
//    }

    @Override
    public void openPage() {
        driver.get(BASE_PAGE + "/customer/account/login/");
    }
}
