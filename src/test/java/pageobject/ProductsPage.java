package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends MenuPage {
	
	@FindAll({ @FindBy(css=".inventory_item_name") })
	List<WebElement> list;
	
	@FindBy(css=".shopping_cart_link")
	WebElement openCartBtn;
	
	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	public void chooseProduct(String name) {
		for (WebElement el : list) {
			if( getText(el).equalsIgnoreCase(name)) {
				el.click();
				break;
			}
		}
	}
	

}
