package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageobject.BasePage;

public class LoginPage extends BasePage {
	
	@FindBy(css="#user-name")
	WebElement username;
	
	@FindBy(css="#password")
	WebElement password;
	
	@FindBy(css="#login-button")
	WebElement loginBtn;
	
	@FindBy(css="[data-test=error]")
	WebElement errorLabel;


	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void login(String user, String password ) {
		this.username.clear();
		this.password.clear();
		fillText(this.username, user);
		fillText(this.password, password);
		click(loginBtn);
	}
	
	public String getPasswordError() {
		return errorLabel.getText();
	}
	
}
