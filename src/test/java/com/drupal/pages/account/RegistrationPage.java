package com.drupal.pages.account;

import org.openqa.selenium.WebElement;

import com.drupal.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class RegistrationPage extends AbstractPage{
	
	@FindBy(id = "edit-name")
	WebElement userInput;
	
	@FindBy(id = "edit-mail")
	WebElement emailAdressInput;
	
	@FindBy(id = "edit-pass-pass1")
	WebElement passwordInput;
	
	@FindBy(id = "edit-pass-pass2")
	WebElement confirmPasswordInput;
	
	@FindBy(id = "edit-submit")
	WebElement createAccountButton;
	
	public void typeUsername(String username){
		userInput.clear();
		userInput.sendKeys(username);
	}
	
	public void typeEmail(String email){
		emailAdressInput.clear();
		emailAdressInput.sendKeys(email);
	}
	
	public void typePassword(String password){
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}
	
	public void typeConfirmPassword(String password){
		confirmPasswordInput.clear();
		confirmPasswordInput.sendKeys(password);
	}
	
	public void clickCreateAccountButton(){
		createAccountButton.click();
	}
	
}
