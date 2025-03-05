package com.proj.cucumber.elements;

import com.proj.framework.AbstractGuiElement;
import org.openqa.selenium.WebElement;

public class Label extends AbstractGuiElement {

    public Label(WebElement element) {
        super(element);
    }

    public Label(WebElement wrappedElement, String name) {
        super(wrappedElement, name);
    }
}
