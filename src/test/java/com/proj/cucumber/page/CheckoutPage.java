package com.proj.cucumber.page;

import com.proj.cucumber.elements.Button;
import com.proj.cucumber.elements.Input;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.proj.framework.driver.WebDriverRunner.getDriver;

public class CheckoutPage extends GenericPage {

    @FindBy(xpath = "//div[@class='cart-summary']//a[@id='checkout-link-button']")
    private WebElement orderAndPayButton;

    @FindBy(xpath = "//button[normalize-space()='Volgende']")
    private WebElement nextButton;

    @FindBy(xpath = "//div[@class='control qty']//input")
    private WebElement qtyField;

    @FindBy(xpath = "//div[@id='card-form']//button[@id='submit-button']")
    private WebElement payButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public Button payButton() {
        return new Button(payButton, "Betaal button");
    }

    public Input qtyField() {
        return new Input(qtyField, "Quantity field");
    }

    public Button orderAndPayButton() {
        return new Button(orderAndPayButton, "Bestellen en betalen button");
    }

    public Button nextButton() {
        return new Button(nextButton, "Volgende button");
    }

    public boolean isCheckoutPageOpened() {
        return tryWaitUntil(() -> getDriver().getTitle().equals("Shopping Cart"));
    }

    public boolean isItemShown(String itemName) {
        String locator = String.format("//div[starts-with(@class, 'cart-form')]//tr//a[normalize-space()='%s']", itemName);
        return tryWaitUntil(() -> getDriver().findElement(By.xpath(locator)).isDisplayed());
    }

    @Override
    public void openPage() {
        
    }
}
