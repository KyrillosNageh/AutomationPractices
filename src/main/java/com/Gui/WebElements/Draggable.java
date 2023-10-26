package com.Gui.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import lombok.NoArgsConstructor;
import wrapper.ElementActions;
import wrapper.SeleDriver;

@NoArgsConstructor
public class Draggable extends ElementActions {
	
	public Draggable(SeleDriver driver) {
		super(driver);
		}

    public Element performDragAndDrop(By sourceLocator, By targetLocator) {
        WebElement sourceElement = ElementActions.setLocator(sourceLocator);
        WebElement targetElement = ElementActions.setLocator(targetLocator);

        new Actions(SeleDriver.getDriver())
        .dragAndDrop(sourceElement, targetElement)
        .build().perform();
        return new Element(); 
    }
}


