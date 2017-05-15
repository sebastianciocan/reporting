package com.drupal.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.drupal.pages.AbstractPage;

public class LoginPage extends AbstractPage {

	@FindBy(id = "edit-name")
	private WebElement usernameInput;

	@FindBy(id = "edit-pass")
	WebElement passwordInput;
	
	@FindBy(id = "edit-submit")
	WebElement logInButton;
	
	public void typeUsername(String username) {
		usernameInput.clear();
		usernameInput.sendKeys(username);

	}

	public void typePassword(String password) {
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}
	


	
}
