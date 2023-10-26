package com.Gui.WebElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.NoArgsConstructor;
import wrapper.SeleDriver;

@NoArgsConstructor
public class Element  {
	public static SeleDriver driver;
	
	public Element(SeleDriver driver) {
		Element.driver =driver;
	}
	
	public static String setLocator(By shadowDom, By locator) {
		new WebDriverWait(SeleDriver.getDriver(), Duration.ofMillis(10000))
		.until(ExpectedConditions.visibilityOfElementLocated(shadowDom));
		SearchContext shadowDomElement= SeleDriver.getDriver()
				.findElement(shadowDom)
				.getShadowRoot();

		return shadowDomElement.findElement(locator).toString();
//		return shadowDomElement.findElement(locator);
	}

	public Button button() {return new Button(driver);}
	public CheckBox checkBox() {return new CheckBox(driver);}
	public Draggable draggable() {return new Draggable(driver);}
	public FileUpload fileUpload() {return new FileUpload(driver);}
	public Iframe iFrame() {return new Iframe(driver);}
	public Image image() {return new Image(driver);}
	public Label label() {return new Label(driver);}
	public Link link() {return new Link(driver);}
	public RadioButton radioButton() {return new RadioButton(driver);}
	public Selector selector() {return new Selector(driver);}
	public Table table() {return new Table(driver);}
	public TextBox textBox() {return new TextBox(driver);}
	public TextArea textArea() {return new TextArea(driver);}


}
