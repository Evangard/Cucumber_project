package com.proj.cucumber.elements;

import com.proj.framework.AbstractGuiElement;
import org.openqa.selenium.WebElement;

public class Button extends AbstractGuiElement {

	public Button(WebElement element) {
		super(element);
	}

	public Button(WebElement element, String name) {
		super(element, name);
	}
}
