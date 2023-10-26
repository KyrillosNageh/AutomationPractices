package com.Gui.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrapper.ElementActions;
import wrapper.SeleDriver;

public class CheckBox extends Button{

	public CheckBox(SeleDriver driver) {
		super(driver);
	}
	
	public boolean isChecked(By locator) {
		WebElement element = ElementActions.setLocator(locator);
		return element.isSelected();
	}

}
