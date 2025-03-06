package com.proj.cucumber.stepdefs;

import com.proj.cucumber.page.CustomerPage;
import com.proj.cucumber.page.LoginPage;
import com.proj.framework.config.TestConfig;
import com.proj.model.Customer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.proj.framework.driver.WebDriverRunner.getDriver;

public class LoginStepDefs {
    private LoginPage loginPage = new LoginPage(getDriver());
    private CustomerPage customerPage = new CustomerPage(getDriver());
    private Customer customer = new Customer(TestConfig.CONFIG.userEmail(), TestConfig.CONFIG.userPassword());

    @Given("User goes to login page")
    public void navigateToLoginPage() {
        loginPage.openPage();
    }

    @When("User enters {string} email and {string} password")
    public void enterEmailAndPassword(String email, String pass) {
        loginPage.setEmail(email);
        loginPage.setPassword(pass);
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
