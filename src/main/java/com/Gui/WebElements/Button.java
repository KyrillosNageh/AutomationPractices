package com.Gui.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import lombok.NoArgsConstructor;
import wrapper.ElementActions;
import wrapper.SeleDriver;

@NoArgsConstructor
public class Button extends Label {

	public Button(SeleDriver driver) {
		super(driver);
	}

	public Element click(By buttonLocator) {
		WebElement element = ElementActions.setLocator(buttonLocator);
		element.click();
		return new Element();
		}
	
	public Element hover(By buttonLocator) {
		WebElement element = ElementActions.setLocator(buttonLocator);
		new Actions(SeleDriver.getDriver()).moveToElement(element).perform();
		return new Element();
	}
	
	public Element hoverAndClick(By buttonLocator) {
		WebElement element = ElementActions.setLocator(buttonLocator);
		 new Actions(SeleDriver.getDriver()).moveToElement(element)
		 .click(element)
		 .perform();
		 return new Element();
	}
}
