package technocredits.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import technocredits.base.PredefinedActions;

public class LoginPage extends PredefinedActions {
		
	public boolean isLogoDisplayed() {
		return isElementDisplayed("id","divLogo",false);
	}
	
	public HomePage doLogin(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
		return new HomePage();
	}
	
	public LoginPage enterUsername(String username) {
		enterText("id", "txtUsername", false, username); 
		return this;
	}
	public LoginPage enterPassword(String password) {
		enterText("id", "txtPassword", false, password); 
		return this;
	}
	public HomePage clickLoginButton() {
		clickOnElement("xpath", "//input[@name='Submit']", false);
		return new HomePage();
	}

}
