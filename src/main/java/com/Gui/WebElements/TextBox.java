package com.Gui.WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import lombok.NoArgsConstructor;
import wrapper.ElementActions;
import wrapper.SeleDriver;
@NoArgsConstructor
public class TextBox extends ElementActions{
	public TextBox(SeleDriver driver) {
		super(driver);
	}
	
	public Element type(By textBoxLocator, String text) {
		WebElement element = ElementActions.setLocator(textBoxLocator);
		element.clear();
		element.sendKeys(text);
		return new Element();
	}
	
	public boolean isRequired() {
		return true;
	}
	
	public String getInputTextLength(By textBoxLocator,TEXT_LENGTH lengthType) {
		WebElement element = ElementActions.setLocator(textBoxLocator);	
		return element.getAttribute(lengthType.getAttribute());	
	}
	
	public enum TEXT_LENGTH{MAX_LENGTH("maxlength"), MIN_LENGTH ("minlength");

	    private final String attribute;

	    TEXT_LENGTH(String attribute) {
	        this.attribute = attribute;
	    }

	    public String getAttribute() {
	        return attribute;
	        }
	    }

}
