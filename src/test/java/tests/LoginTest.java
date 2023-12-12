package tests;

import pageobject.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Excel;


public class LoginTest extends BaseTest {

	
	public void waitSecond(long ms) { 
		try {
			Thread.sleep(ms * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test( dataProvider="getData2", description = "Have error message when bad credentials")
	public void tc01_loginFailed(String user, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.login(user, password);
		boolean haveErrorMsg = lp.getPasswordError().length() == 0;
		Assert.assertTrue(haveErrorMsg);
	}	
	
	@Test(description = "Get bad credentials error")
	public void tc02_loginFailed() {
		driver.navigate().refresh();
		LoginPage lp = new LoginPage(driver);
		lp.login("s", "s");
		String expected = "Epic sadface: Username and password do not match any user in this service";
		String currentlyHave = lp.getPasswordError();
		Assert.assertEquals(currentlyHave, expected);
	}	
	
//	@Test(description = "Testing the login with the right user and the right password.")
//	public void tc03_loginSucceed() {
//		LoginPage lp = new LoginPage(driver);
//		lp.login("standard_user", "secret_sauce");
//		waitSecond(2);
//	}	
//	
	@Test(description = "Get empty password error")
	public void tc03_loginFailed() {
		driver.navigate().refresh();
		LoginPage lp = new LoginPage(driver);
		lp.login("standard_user","");
		String expected = "Epic sadface: Password is required";
		String currentlyHave = lp.getPasswordError();
		Assert.assertEquals(currentlyHave, expected);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] myData = {
				{"user1","123"},
				{"gal","123"},
				{"yonit","1#444"},
				{"gal","123456878"},
		};
		return myData;
	}
	
	@DataProvider
	public Object[][] getData2(){
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\LoginData.xlsx";
		System.out.println(excelPath);
		Object[][] table = Excel.getTableArray(excelPath, "Feuille 1");
		return table;
	}
}
