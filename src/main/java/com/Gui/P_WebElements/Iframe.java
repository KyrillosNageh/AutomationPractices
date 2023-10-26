package com.Gui.P_WebElements;

import wrapperPlaywright.ElementActions;
import wrapperPlaywright.PlayBrowse;

public class Iframe extends ElementActions {
    public Iframe(PlayBrowse driver) {
        super(driver);
    }

    public Element switchToIframe(String iFrameSelector) {
        PlayBrowse.getPage().frame(iFrameSelector);
        return new Element();
    }

    public Element switchToDefaultContent() {
    	PlayBrowse.getPage().frame(null);
    	return new Element();
    }
}