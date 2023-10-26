package com.Gui.P_WebElements;

import com.microsoft.playwright.ElementHandle;

import lombok.NoArgsConstructor;
import wrapperPlaywright.ElementActions;
import wrapperPlaywright.PlayBrowse;

@NoArgsConstructor
public class Label extends ElementActions {
    public Label(PlayBrowse driver) {
        super(driver);
    }

    public String getText(String labelSelector) {
        ElementHandle element = setLocator(labelSelector);
        return element.innerText();
    }

    public int getCount(String labelSelector) {
        return getCount(labelSelector);
    }


}
