package com.Gui.P_WebElements;


import lombok.NoArgsConstructor;
import wrapperPlaywright.PlayBrowse;

@NoArgsConstructor
public class Element {
	public static PlayBrowse driver;
	
	public Element(PlayBrowse driver) {
		Element.driver =driver;
	}

	public Button button() {return new Button(driver);}
	public CheckBox checkBox() {return new CheckBox(driver);}
//	public Draggable draggable() {return new Draggable(driver);}
//	public FileUpload fileUpload() {return new FileUpload(driver);}
	public Iframe iFrame() {return new Iframe(driver);}
//	public Image image() {return new Image(driver);}
	public Label label() {return new Label(driver);}
//	public Link link() {return new Link(driver);}
	public RadioButton radioButton() {return new RadioButton(driver);}
//	public Selector selector() {return new Selector(driver);}
//	public Table table() {return new Table(driver);}
	public TextBox textBox() {return new TextBox(driver);}
//	public TextArea textArea() {return new TextArea(driver);}
}
