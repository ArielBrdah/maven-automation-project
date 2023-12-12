package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageobject.BasePage;

public class MenuPage extends BasePage {
	
	@FindBy(css=".shopping_cart_link")
	WebElement cartBtn;
	
	public MenuPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void openCart() {
		click(cartBtn);
	}
}
