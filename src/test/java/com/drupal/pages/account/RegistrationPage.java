package com.drupal.pages.account;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	
	@FindBy(css = "div.messages.status h2.element-invisible")
	WebElement registrationSuccessfulStatus;
	
	@FindBy(css = "div.messages.status")
	WebElement registrationSuccessfulText;
	
	@FindBy(css = "div.messages.error")
	WebElement unableToSendEmail;
	
	@FindBy(css = "div.messages.error a")
	WebElement recoverPasswordLink;
	
	@FindBy(css = "div.form-item.form-type-textfield.form-item-name input")
	WebElement emailForPasswordRecoveryInput;
	
	@FindBy(css = "input#edit-submit")
	WebElement sendNewPasswordButton;
	
	@FindBy(css = "div.password-confirm span")
	WebElement passwordsMatchSpan;
	
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
	
	public String getRegistrationSuccesfulText(){
		
		return registrationSuccessfulText.getText();
	}
	
	public String getEmailSentSuccesfullyText(){
		return unableToSendEmail.getText();
	}
	
	public void unableToSendEmailErrorMessage(){
		assertFalse("Unable to send e-mail",getEmailSentSuccesfullyText().contains("Unable to send e-mail. Contact the site administrator if the problem persists."));
	}
	public void accountIsSuccessfulyRegistered(){
		assertTrue("Not the expected message", getRegistrationSuccesfulText().contains("Registration successful. You are now logged in."));
		unableToSendEmailErrorMessage();
	}
	
	public void usernameAlreadyExists(){
		assertTrue("An account with an existing userName was created", 
				getEmailSentSuccesfullyText().contains("The name " + "victor" + " is already taken."));
	}
	
	public void emailAlreadyExists(){
		assertTrue("An account with an existing userName was created", 
				getEmailSentSuccesfullyText().contains("The e-mail address " + "victortomaciprian@gmail.com" + " is already registered. "));
	}
	
	public void clickRecoverPasswordLink(){
		recoverPasswordLink.click();
	}
	
	public void typeEmailForPasswordRecovery(String recoveryEmail){
		emailForPasswordRecoveryInput.clear();
		emailForPasswordRecoveryInput.sendKeys(recoveryEmail);
	}
	
	public void clickSendPasswordToEmailButton(){
		sendNewPasswordButton.click();
	} 
	
	public void userNameFieldIsRequiredMessage(){
		assertTrue("An account without an username was created", getEmailSentSuccesfullyText().contains("Username field is required."));
	}
	
	public void emailFieldIsRequiredMessage(){
		assertTrue("An account without an email was created", getEmailSentSuccesfullyText().contains("E-mail address field is required."));
	}
	
	public String getPasswordsMatchText(){
		return passwordsMatchSpan.getText();
	}
	
	public void passwordsMatch(){
		assertTrue("Matching passwords were identified as not matching", getPasswordsMatchText().contentEquals("yes"));
	}
	
	public void passwordsNotMatching(){
		assertTrue("Not matching passwords were identified as matching", getPasswordsMatchText().contentEquals("no"));
	}
	
}
