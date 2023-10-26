package com.Gui.WebElements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import lombok.NoArgsConstructor;
import wrapper.ElementActions;
import wrapper.SeleDriver;

@NoArgsConstructor
public class Link extends ElementActions {
	private static List<String> brokenLinks = new ArrayList<>();

	public Link(SeleDriver driver) {
		super(driver);
	}
	
	public Element click(By linkLocator) {
		WebElement element = ElementActions.setLocator(linkLocator);
		element.click();
		return new Element();
		}
	
	   public List<String> getBrokenLinks() {
	        List<WebElement> links = SeleDriver.getDriver()
	        		.findElements(By.tagName("a"));

	        for (WebElement link : links) {
	            String linkUrl = link.getAttribute("href");
	            try {
	                HttpURLConnection connection = (HttpURLConnection) new URL(linkUrl).openConnection();
	                connection.setRequestMethod("HEAD");
	                connection.connect();
	                int responseCode = connection.getResponseCode();
	                if (responseCode != 200) {
	                	brokenLinks.add(linkUrl);
	                    System.out.println("Broken link URL: " + linkUrl);
	                    System.out.println("HTTP status code: " + responseCode);
	                }
	            } catch (IOException e) {
	            	brokenLinks.add(linkUrl);
	                System.out.println("Error checking link: " + linkUrl);
	            }
	        }
	        return brokenLinks;
	   }
	   

}
