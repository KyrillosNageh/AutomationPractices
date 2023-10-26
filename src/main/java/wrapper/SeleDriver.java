package wrapper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class SeleDriver {

	private static final ThreadLocal<WebDriverManager> webDriverManager = new ThreadLocal<>();	
	@Setter(AccessLevel.PUBLIC)
	@Getter(AccessLevel.PUBLIC)
	private static WebDriver driver;	
    @Getter(AccessLevel.PUBLIC)
	private static String targetBrowserName="chrome";
	
	public SeleDriver(){
		configureBrowser();
	}
	
	public void configureBrowser() {
		
        if (targetBrowserName.equalsIgnoreCase("chrome")) {        	
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (targetBrowserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (targetBrowserName.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else if (targetBrowserName.equalsIgnoreCase("remot")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + targetBrowserName);
        }
	}
	
	
}
