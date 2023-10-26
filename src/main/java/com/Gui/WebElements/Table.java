package com.Gui.WebElements;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import lombok.NoArgsConstructor;
import wrapper.ElementActions;
import wrapper.SeleDriver;

@NoArgsConstructor
public class Table extends ElementActions{

	private static Label label;
	private static List<List<String>> tableData = new ArrayList<>();
	public Table(SeleDriver driver) {
		super(driver);
		label =new Label();
		}
	
    public List<List<String>> getTableData(By tableLocator) {
        
        // Find the table element
        WebElement table = Label.setLocator(tableLocator);

        // Find all rows in the table
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<String> rowData = new ArrayList<>();
            List<WebElement> cells = row.findElements(By.tagName("td"));

            for (WebElement cell : cells) {
                // Extract text from each cell using the Label class
                rowData.add(label.getText(cell));
            }

            tableData.add(rowData);
        }

        return tableData;
    }
	
    public String getTableRowText(By tableLocator, int rowNumber) {
        // Find the table element
        WebElement table = ElementActions.setLocator(tableLocator);

        // Find all rows in the table
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        if (rowNumber >= 0 && rowNumber < rows.size()) {
            // Get the specified row
            WebElement row = rows.get(rowNumber);

            // Extract the text from the row
            return row.getText();
        } else {
            return null; // Row number out of range
        }
    }
    
    
}
