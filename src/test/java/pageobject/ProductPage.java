package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends MenuPage {
	
	@FindBy(css=".btn.btn_primary.btn_small.btn_inventory")
	WebElement addBtn;
	
	@FindBy(css="#back-to-products")
	WebElement backBtn;
	

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	public void addToCart() {
		click(addBtn);
	}
	
	public void back() { 
		click(backBtn);
	}
	
	

}
