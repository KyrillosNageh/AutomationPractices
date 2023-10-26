package com.Gui.P_WebElements;

import com.microsoft.playwright.ElementHandle;

import lombok.NoArgsConstructor;
import wrapperPlaywright.PlayBrowse;

@NoArgsConstructor
public class Button extends Label {
    public Button(PlayBrowse driver) {
        super(driver);
    }

    public Element click(String buttonSelector) {
        ElementHandle element = setLocator(buttonSelector);
        element.click();
        return new Element();
    }

    public Element hover(String buttonSelector) {
        ElementHandle element = setLocator(buttonSelector);
        element.hover();
        return new Element();
    }

    public Element hoverAndClick(String buttonSelector) {
        ElementHandle element = setLocator(buttonSelector);
        element.hover();
        element.click();
        return new Element();
    }
}
