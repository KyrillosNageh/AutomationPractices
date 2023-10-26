package wrapper;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public abstract class ElementActions {
	@Getter(value = AccessLevel.PUBLIC)
	@Setter(value = AccessLevel.PUBLIC)
	private static SeleDriver driver;
	@Setter(value = AccessLevel.PUBLIC)
	private static long elementTimeOut;
	
	public ElementActions(SeleDriver driver){
		ElementActions.driver = driver;
	}
	
	
	public static WebElement setLocator(By locator) {
		new WebDriverWait(SeleDriver.getDriver(), Duration.ofMillis(10000))
		.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return SeleDriver.getDriver().findElement(locator);
	}
	
	public static WebElement setLocator(WebElement element) {
		new WebDriverWait(SeleDriver.getDriver(), Duration.ofMillis(10000))
		.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	public static int getElementsCount(By locator ) {
		new WebDriverWait(SeleDriver.getDriver(), Duration.ofMillis(10000))
		.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return  SeleDriver.getDriver().findElements(locator).size();
	}

	public static List<WebElement> getElements(By locator ) {
		new WebDriverWait(SeleDriver.getDriver(), Duration.ofMillis(10000))
		.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return  SeleDriver.getDriver().findElements(locator);
	}

}
