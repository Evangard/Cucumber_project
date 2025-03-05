package com.proj.cucumber.stepdefs;

import com.proj.cucumber.page.CheckoutPage;
import com.proj.cucumber.page.HomePage;
import com.proj.framework.tools.enums.Tabs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.proj.framework.driver.WebDriverRunner.getDriver;

public class CheckoutStepDefs {

    private HomePage homePage = new HomePage(getDriver());
    private CheckoutPage checkoutPage = new CheckoutPage(getDriver());

    @Given("User goes to home page")
    public void navigateToHomePage() {
        homePage.openPage();
    }

    @When("User opens {string} tab")
    public void navigateToTab(String tabName) {
        homePage.openTab(tabName);
    }

    @And("User select {string} category")
    public void selectCategory(String categoryName) {
        homePage.selectCategory(categoryName);
    }

    @And("User adds {string} item to cart")
    public void addItemToCart(String itemName) {
        homePage.addItemToCart(itemName);
    }

    @And("User clicks on To order button")
    public void clickOnOrderButton() {
        homePage.clickOnToOrderButton();
    }

    @Then("Cart should be opened")
    public void verifyCartIsOpened() {
        Assert.assertTrue(checkoutPage.isCheckoutPageOpened(),"Cart should be opened.");
    }

    @And("Chosen {string} item is shown")
    public void verifyChosenItemIsShown(String name) {
        Assert.assertTrue(checkoutPage.isItemShown(name), String.format("'%s' item should be shown.", name));
    }
}
