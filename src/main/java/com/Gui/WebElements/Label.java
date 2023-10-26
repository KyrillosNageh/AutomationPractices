package com.Gui.WebElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import lombok.NoArgsConstructor;
import wrapper.ElementActions;
import wrapper.SeleDriver;

@NoArgsConstructor
public class Label extends ElementActions{
	
	public Label(SeleDriver driver) {
		super(driver);
	}
	
	public String getText(By labelLocator) {
		WebElement element = ElementActions.setLocator(labelLocator);
		return element.getText();
	}
	
	public String getText(WebElement webElement) {
		WebElement element = ElementActions.setLocator(webElement);
		return element.getText();
	}
	
	public int getCount(By labelLocator) {
		return ElementActions.getElementsCount(labelLocator);
	}
	
	public List<WebElement> getLabels(By labelLocator) {
		return ElementActions.getElements(labelLocator);
	}

}
