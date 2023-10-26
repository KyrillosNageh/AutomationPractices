package com.Gui.P_WebElements;

import com.microsoft.playwright.ElementHandle;

import wrapperPlaywright.PlayBrowse;

public class CheckBox extends Button {
    public CheckBox(PlayBrowse driver) {
        super(driver);
    }

    public boolean isChecked(String locator) {
        ElementHandle element = setLocator(locator);
        return element.isChecked();
    }
}
