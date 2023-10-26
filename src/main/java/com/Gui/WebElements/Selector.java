package com.Gui.WebElements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import lombok.NoArgsConstructor;
import wrapper.ElementActions;
import wrapper.SeleDriver;

@NoArgsConstructor
public class Selector extends ElementActions {
	
	public Selector(SeleDriver driver) {
		super(driver);
	}
	
	public Element selectByIndex(By selectorLocator,int option) {
		WebElement element = ElementActions.setLocator(selectorLocator);
		Select select = new Select(element);
		select.selectByIndex( option);

		return new Element();
		}
	
	public Element selectByValue(By selectorLocator,String option) {
		WebElement element = ElementActions.setLocator(selectorLocator);
		Select select = new Select(element);
		select.selectByVisibleText( option);

		return new Element();
		}
	
	public Element selectMultipleOptions(By selectorLocator, String...options) {
		WebElement element = ElementActions.setLocator(selectorLocator);
		Select select = new Select(element);
		if (!select.isMultiple()) { 
			select.deselectAll();
	        for (String optionValue : options) {
	            select.selectByVisibleText(optionValue);
	            }
	        }
		else {
            throw new UnsupportedOperationException("The element is not a multiple select.");
            }
		
		return new Element();
		}

}
