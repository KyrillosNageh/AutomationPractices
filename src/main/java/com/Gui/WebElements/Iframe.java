package com.Gui.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import lombok.NoArgsConstructor;
import wrapper.ElementActions;
import wrapper.SeleDriver;
@NoArgsConstructor
public class Iframe extends ElementActions {

	public Iframe(SeleDriver driver) {
		super(driver);
	}
	
	public Element switchToIframe(By iFrameLocator) {
		WebElement iframe = ElementActions.setLocator(iFrameLocator);
		SeleDriver.getDriver().switchTo().frame(iframe);
		return new Element();
	}
	
    public Element switchToDefaultContent() {
    	SeleDriver.getDriver().switchTo().defaultContent();
    	return new Element();
    }
}
