package com.proj.cucumber.stepdefs;

import com.proj.cucumber.page.CustomerPage;
import com.proj.cucumber.page.HomePage;
import com.proj.cucumber.page.LoginPage;
import com.proj.framework.driver.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.proj.framework.driver.WebDriverRunner.getDriver;

public class LoginStepDefs {
    private LoginPage loginPage = new LoginPage(getDriver());
    private CustomerPage customerPage = new CustomerPage(getDriver());
    @Given("User goes to login page")
    public void navigateToLoginPage() {
        loginPage.openPage();
    }

    @When("User enters email {string} and password {string}")
    public void enterEmailAndPassword(String email, String password) {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
    }

    @And("User clicks on login button")
    public void clickOnLoginButton() {
        loginPage.clickSubmitButton();
    }

    @Then("User should be logged in")
    public void verifyThatUserIsLogged() {
        Assert.assertTrue(customerPage.isCustomerPageShown(), "User should be logged in.");
    }
}
