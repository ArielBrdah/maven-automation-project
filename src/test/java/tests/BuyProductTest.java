package tests;

import pageobject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.annotations.*;

public class BuyProductTest extends BaseTest {
	
	@Test
	public void tc01_login() {
		LoginPage lp = new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
		System.out.println(System.getenv("salut"));
	}

	@Test
	public void tc02_addProduct1() {
		
		ProductsPage psp = new ProductsPage(driver);
		psp.chooseProduct("Sauce Labs Bolt T-Shirt");
		
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.back();
	}
	
	@Test
	public void tc03_addProduct2() {
		
		ProductsPage psp = new ProductsPage(driver);
		psp.chooseProduct("Test.allTheThings() T-Shirt (Red)");
		
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.back();	
	}
	
	@Test
	public void tc04_payment() {
			
		ProductsPage psp = new ProductsPage(driver);
		psp.openCart();
		
		YourCartPage ycp = new YourCartPage(driver);
		ycp.checkout();		
	}
	

}
