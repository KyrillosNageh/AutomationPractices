package wrapperPlaywright;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

import io.netty.handler.timeout.TimeoutException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class ElementActions {
	@Getter(value = AccessLevel.PUBLIC)
	@Setter(value = AccessLevel.PUBLIC)
	private static PlayBrowse driver;
	
	private final Page page;
	
	public ElementActions() {
		this.page = null;}
	
	public ElementActions(PlayBrowse driver){
		ElementActions.driver = driver;
        this.page = driver.getPage();
	}
	
    public ElementHandle setLocator(String selector) {
        try {
            return page.waitForSelector(selector, new Page.WaitForSelectorOptions().setTimeout(100));
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not found: " + selector);
        }
    }
}
