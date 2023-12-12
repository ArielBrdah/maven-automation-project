package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageobject.BasePage;

public class YourCartPage extends BasePage{

	@FindBy(css=".checkout_button")
	private WebElement checkoutBtn;
	
	public YourCartPage(WebDriver driver) {
		super(driver);
	}
	
	public void checkout() {
		click( checkoutBtn );
	}
}
