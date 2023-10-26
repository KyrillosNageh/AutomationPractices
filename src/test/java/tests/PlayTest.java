package tests;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Gui.P_WebElements.Button;
import com.Gui.WebElements.Link;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import wrapper.SeleDriver;
import wrapperPlaywright.ElementActions;
import wrapperPlaywright.PlayBrowse;

public class PlayTest {

	PlayBrowse driver;
	
	@Test 
	public void verifyButtonElementActions() {
		driver = new PlayBrowse();
		Page page = driver.getPage();
		page.navigate("https://the-internet.herokuapp.com/");
		new Button(driver).click("//a[contains(text(),'Frames')]")
		.button().click("//a[contains(text(),'iFrame')]");
	}
	
	@Test 
	public void verifyIframeElementActions() {
		driver = new PlayBrowse();
		Page page = driver.getPage();
		page.navigate("https://the-internet.herokuapp.com/");
		new Button(driver).click("//a[contains(text(),'Frames')]")
		.button().click("//a[contains(text(),'iFrame')]")
		.iFrame().switchToIframe("tox-edit-area__iframe")
		.textBox().type("#tinymce", "Kyrillos Nageh >>> Software Development In Test");
		
	}
	
}
