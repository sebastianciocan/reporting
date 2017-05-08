package com.drupal.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.drupal.pages.AbstractPage;

public class LoginPage extends AbstractPage {

	@FindBy(id = "edit-name")
	private WebElement emailInput;

	@FindBy(id = "edit-pass")
	WebElement passwordInput;

	public void typeEmail(String email) {
		emailInput.clear();
		emailInput.sendKeys(email);

	}

	public void typePassword(String password) {
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}

	public void login(String email, String password) {
		typeEmail(email);
		typePassword(password);
		getDriver().findElement(By.id("edit-submit")).click();
	}
}
