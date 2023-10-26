package com.Gui.WebElements;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import lombok.NoArgsConstructor;
import wrapper.ElementActions;
import wrapper.SeleDriver;

@NoArgsConstructor
public class FileUpload extends ElementActions{
	private TextBox textBox;
	public FileUpload(SeleDriver driver) {
		super(driver);
		textBox = new TextBox();
		}
	
    public Element uploadFile(By fileUploadtLocator, String filePath) {
		textBox.type(fileUploadtLocator, filePath);
        return new Element();
        }
    
    public Element uploadMultipleFiles(By fileUploadtLocator, String... filePaths) {
        // Concatenate the file paths separated by a newline character
        String allFiles = String.join("\n", filePaths);

        textBox.type(fileUploadtLocator, allFiles);
        return new Element();
    }
    
    public  Element uploadFileuUsing(By fileUploadtLocator, String filePath) {
//    	WebElement element = setLocator(fileUploadtLocator);
//    	element.click();
    	try {
    		 // Simulate a keypress for Ctrl + C (copy)
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            // Create a Robot instance
            Robot robot = new Robot();

            // Simulate a keypress for Ctrl + V (paste)
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Simulate pressing Enter
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Element();
        }
    
    
}
