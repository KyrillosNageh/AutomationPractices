package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Gui.WebElements.*;

import wrapper.SeleDriver;

public class App {
	SeleDriver driver;
	@Test
	public void verifyLinkElementActions() {
		driver = new SeleDriver();
		SeleDriver.getDriver().navigate().to("https://demo.guru99.com/test/newtours/");
		new Link(driver).getBrokenLinks();
	}
	
	@Test 
	public void verifyCheckboxElementActions() {
		driver = new SeleDriver();
		SeleDriver.getDriver().navigate().to("https://the-internet.herokuapp.com/");
		new Link(driver).click(By.xpath(("//a[contains(text(),'Checkboxes')]")));
		boolean elementStatus= new CheckBox(driver).isChecked(By.xpath("(//*[@type='checkbox'])[1]"));
		if (elementStatus == true) {
			System.out.println("Element is checked");
		}
		else {System.out.println("Element is  not checked");
			new CheckBox(driver).click(By.xpath("(//*[@type='checkbox'])[1]"));
		}
		
		elementStatus= new CheckBox(driver).isChecked(By.xpath("(//*[@type='checkbox'])[1]"));
		if (elementStatus == true) {
			System.out.println("Element is checked");
		}
		else {System.out.println("Element is  not checked");}
	}
	
	@Test 
	public void verifyImageElementActions() {
		driver = new SeleDriver();
		SeleDriver.getDriver().navigate().to("https://the-internet.herokuapp.com/");
		new Link(driver).click(By.xpath(("//a[contains(text(),'Broken Images')]")));
		new Image(driver).getBrokenImages();
	}
	
	@Test 
	public void verifyIframeElementActions() {
		driver = new SeleDriver();
		SeleDriver.getDriver().navigate().to("https://the-internet.herokuapp.com/");
		new Link(driver).click(By.xpath(("//a[contains(text(),'Frames')]")))
		.link().click(By.xpath(("//a[contains(text(),'iFrame')]")))
		.iFrame().switchToIframe(By.className("tox-edit-area__iframe"))
		.textBox().type(By.id("tinymce"), "Kyrillos Nageh >>> Software Development In Test");
	}
	
	@Test 
	public void verifyButtonElementActions() {
		driver = new SeleDriver();
		SeleDriver.getDriver().navigate().to("https://the-internet.herokuapp.com/");
		new Button(driver).click(By.xpath(("//a[contains(text(),'Frames')]")))
		.button().click(By.xpath(("//a[contains(text(),'iFrame')]")));
	}
	
	@Test 
	public void verifyDraggableElementActions() {
		driver = new SeleDriver();
		SeleDriver.getDriver().navigate().to("https://the-internet.herokuapp.com/");
		new Button(driver).click(By.xpath(("//a[contains(text(),'Drag and Drop')]")))
		.draggable().performDragAndDrop(By.id("column-a"), By.id("column-b"));
		System.out.println("Element A now is >>> "+ new Label().getText(By.id("column-a")));
		System.out.println("Element B now is >>> "+ new Label().getText(By.id("column-b")));
	}
	
	@Test 
	public void verifyShadowDomElementActions() {
		driver = new SeleDriver();
		SeleDriver.getDriver().navigate().to("https://the-internet.herokuapp.com/");
		System.out.println(
		new Element(driver).link()
		.click(By.xpath(("//a[contains(text(),'Shadow DOM')]")))
		.setLocator(By.xpath(("(//my-paragraph)[2]")), By.xpath(("(//li)[1]")))
		);
	}
	
	@Test 
	public void verifyFileUploadElementActions() {
		driver = new SeleDriver();
		SeleDriver.getDriver().navigate().to("https://the-internet.herokuapp.com/");
		/*** 	Upload using Send keys		***/
//		new Link(driver).click(By.xpath(("//a[contains(text(),'File Upload')]")))
//		.fileUpload().uploadFile(By.id("file-upload"),"D:\\Testing\\projects\\AutomationPractices\\src\\main\\resources\\fileUploadData\\Elements UML class.png");

		/*** 	Upload using Robot java to simulate user interactions		***/
//		new Link(driver).click(By.xpath(("//a[contains(text(),'File Upload')]")))
//		.button().click(By.id("drag-drop-upload"))
//		.fileUpload().uploadFileuUsing(By.id("file-upload"), "D:\\Testing\\projects\\AutomationPractices\\src\\main\\resources\\fileUploadData\\Elements UML class.png");
		/****************************************************************************/
		new Link(driver).click(By.xpath(("//a[contains(text(),'File Upload')]")))
		.button().click(By.id("file-upload"))
		.fileUpload().uploadFileuUsing(By.id("file-upload"), "D:\\Testing\\projects\\AutomationPractices\\src\\main\\resources\\fileUploadData\\Elements UML class.png");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test 
	public void verifyTableElementActions() {
		driver = new SeleDriver();
		SeleDriver.getDriver().navigate().to("https://the-internet.herokuapp.com/");
		List<List<String>> tableData = new Button(driver).click(By.xpath(("//a[contains(text(),'Sortable Data Tables')]")))
		.table().getTableData(By.id("table1"));
        for (List<String> row : tableData) {
            for (String cellData : row) {
                System.out.print(cellData + "\t");
            }
            System.out.println();
        }
	
	}
	
	
}
