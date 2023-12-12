package pageobject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	public void fillText( WebElement el, String text ) {
		highlightElement(el, "yellow");
		el.clear();
		el.sendKeys(text);
	}
	
	public void click( WebElement el ) { 
		highlightElement(el, "yellow");
		el.click();
	}
	
	public String getText( WebElement el ) {
		return el.getText();
	}
	
	public void sleep( long mills ) { 
		try {
				Thread.sleep(mills);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected void waitSecond(long ms) { 
		try {
			Thread.sleep(ms * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void highlightElement(WebElement element, String color) {
		//keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Change the style 
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);

		// Change the style back after few miliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}
	
	public void refresh() {
		this.driver.navigate().refresh();
	}
	
}
