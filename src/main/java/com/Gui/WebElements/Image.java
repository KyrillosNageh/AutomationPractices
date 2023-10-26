package com.Gui.WebElements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import lombok.NoArgsConstructor;
import wrapper.ElementActions;
import wrapper.SeleDriver;
@NoArgsConstructor
public class Image extends ElementActions{
	
	public Image(SeleDriver driver) {
		super(driver);
	}
	
	public Element click(By ImageLocator) {
		WebElement element = ElementActions.setLocator(ImageLocator);
		element.click();
		return new Element();
	}
	
	public Element hover(By ImageLocator) {
		WebElement element = ElementActions.setLocator(ImageLocator);
		 new Actions(SeleDriver.getDriver()).moveToElement(element).perform();
		return new Element();
	}
	
	public Element hoverAndClick(By ImageLocator) {
		WebElement element = ElementActions.setLocator(ImageLocator);
		new Actions(SeleDriver.getDriver()).moveToElement(element)
		.click(element)
		.perform();
		return new Element();

	}
	
    public void getBrokenImages() {
        List<WebElement> images = SeleDriver.getDriver()
        		.findElements(By.tagName("img"));

        for (WebElement image : images) {
            String imageUrl = image.getAttribute("src");
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(imageUrl).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode != 200) {
                    System.out.println("Broken image URL: " + imageUrl);
                    System.out.println("HTTP status code: " + responseCode);
                }
            } catch (IOException e) {
                System.out.println("Error checking image: " + imageUrl);
            }
        }
    }

}
