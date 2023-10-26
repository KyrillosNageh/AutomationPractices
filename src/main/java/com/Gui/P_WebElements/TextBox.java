package com.Gui.P_WebElements;

import com.microsoft.playwright.ElementHandle;
import wrapperPlaywright.ElementActions;
import wrapperPlaywright.PlayBrowse;

public class TextBox extends ElementActions {
    public TextBox(PlayBrowse driver) {
        super(driver);
    }

    public Element type(String textBoxSelector, String text) {
        ElementHandle element = setLocator(textBoxSelector);
        element.click();
        element.fill(text);
		return new Element();

    }

    public boolean isRequired() {
        return true; // You can customize this based on your application's requirements
    }

    public String getInputTextLength(String textBoxSelector, TEXT_LENGTH lengthType) {
        ElementHandle element = setLocator(textBoxSelector);
        return element.getAttribute(lengthType.getAttribute());
    }

    public enum TEXT_LENGTH {
        MAX_LENGTH("maxlength"), MIN_LENGTH("minlength");

        private final String attribute;

        TEXT_LENGTH(String attribute) {
            this.attribute = attribute;
        }

        public String getAttribute() {
            return attribute;
        }
    }
}
