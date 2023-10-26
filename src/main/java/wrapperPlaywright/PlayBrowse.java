package wrapperPlaywright;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
//import com.microsoft.playwright.options.BrowserContextOptions;
//import com.microsoft.playwright.options.BrowserTypeLaunchOptions;

public class PlayBrowse {
    private static final ThreadLocal<Playwright> playwrightThreadLocal = ThreadLocal.withInitial(Playwright::create);
    private static final ThreadLocal<Browser> browserThreadLocal = ThreadLocal.withInitial(() -> getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100)));

    private static Page page;
    private static String targetBrowserName = "chromium"; // You can change this to "firefox" or "webkit" as needed

    public PlayBrowse() {
    	getPlaywright();
        configureBrowser();
    }

    public void configureBrowser() {
        if (targetBrowserName.equalsIgnoreCase("chromium")) {
            Browser browser = getBrowser();
            BrowserContext context = browser.newContext();
            page = context.newPage();
        } else if (targetBrowserName.equalsIgnoreCase("firefox")) {
            Browser browser = getBrowser();
            BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
            options.setChannel("firefox");
            options.setHeadless(false);
            BrowserContext context = browser.newContext();
            page = context.newPage();
        } else if (targetBrowserName.equalsIgnoreCase("webkit")) {
            Browser browser = getBrowser();
            BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
            options.setChannel("webkit");
            options.setHeadless(false);
            BrowserContext context = browser.newContext();
            page = context.newPage();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + targetBrowserName);
        }
    }

    public static Page getPage() {
        return page;
    }

    public static Playwright getPlaywright() {
        return playwrightThreadLocal.get();
    }
    
    public Browser getBrowser() {
        return browserThreadLocal.get();
    }

    public static void closeBrowser() {
        getPlaywright().close();
    }
}
