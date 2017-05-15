package com.drupal.steps;

import com.drupal.pages.account.RegistrationPage;
import com.drupal.pages.header.UserZonePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class RegistrationSteps extends AbstractSteps {
	private static final long serialVersionUID = 816308171341383739L;
	RegistrationPage registration = new RegistrationPage();
	UserZonePage navigateToAccount = new UserZonePage();
	

	@Step
	public void typeUsername(String userName) {
		registration.typeUsername(userName);

	}

	@Step
	public void typeEmail(String userEmail) {
		registration.typeEmail(userEmail);

	}

	@Step
	public void typePassword(String userPassword) {
		registration.typePassword(userPassword);

	}

	@Step
	public void typeConfirmPassword(String userPassword) {
		registration.typeConfirmPassword(userPassword);

	}
	
	@Step
	public void clickCreateNewAccountButton() {
		registration.clickCreateAccountButton();
	}
	@Step
	public String getRegistrationSuccesfulText() {
		// TODO Auto-generated method stub
		return registration.getRegistrationSuccesfulText();
	}
	
	@Step
	public String getEmailSentSuccesfullyMessage(){
		return registration.getEmailSentSuccesfullyText();
	}
	
	@Step
	public void assertAccountIsCreatedSuccessfuly(){
		registration.accountIsSuccessfulyRegistered();
	}
	
	
	
	@StepGroup
	public void performRegistration(String userName, String email, String password){
		navigateToAccount.goToRegistrationPage();
		typeUsername(userName);
		typeEmail(email);
		typePassword(password);
		typeConfirmPassword(password);		
		clickCreateNewAccountButton();
		assertAccountIsCreatedSuccessfuly();
	}
	
	@Step
	public void assertUsernameAlreadyExists(){
		registration.usernameAlreadyExists();
	}
	
	@StepGroup
	public void registerWithExistingUserName(String userName, String email, String password){
		navigateToAccount.goToRegistrationPage();
		typeUsername(userName);
		typeEmail(email);
		typePassword(password);
		typeConfirmPassword(password);		
		clickCreateNewAccountButton();
		assertUsernameAlreadyExists();
	}
	
	@Step
	public void assertEmailAlreadyExists(){
		registration.emailAlreadyExists();
	}
	
	@StepGroup
	public void registerWithExistingEmail(String userName, String email, String password){
		navigateToAccount.goToRegistrationPage();
		typeUsername(userName);
		typeEmail(email);
		typePassword(password);
		typeConfirmPassword(password);		
		clickCreateNewAccountButton();
		assertEmailAlreadyExists();
	}
	
	@Step
	public void clickRecoverPasswordLink(){
		registration.clickRecoverPasswordLink();
	}
	
	@Step
	public void typeEmailForPasswordRecovery(String recoveryEmail){
		registration.typeEmailForPasswordRecovery(recoveryEmail);
	}
	
	@Step 
	public void clickSendEmailForPasswordRecoveryButton(){
		registration.clickSendPasswordToEmailButton();
	}
	
	@Step
	public void assertEmailIsSent() {
		registration.getEmailSentSuccesfullyText();
		
	}
	
	@Step
	public void assertUserNameIsMissing(){
		registration.userNameFieldIsRequiredMessage();
	}
	
	@StepGroup
	public void registerWithoutAnUsername(String email, String password){
		navigateToAccount.goToRegistrationPage();
		typeEmail(email);
		typePassword(password);
		typeConfirmPassword(password);		
		clickCreateNewAccountButton();
		assertUserNameIsMissing();
	}
	
	@Step
	public void assertEmailIsMissing(){
		registration.emailFieldIsRequiredMessage();
	}
	
	@StepGroup
	public void registerWithoutAnEmail(String userName, String password){
		navigateToAccount.goToRegistrationPage();
		typeUsername(userName);
		typePassword(password);
		typeConfirmPassword(password);		
		clickCreateNewAccountButton();
		assertEmailIsMissing();
	}
	
	@Step
	public void assertmatchingPasswords(){
		registration.passwordsMatch();
	}
	
	@StepGroup
	public void checkMatchingPasswordsAgainstEachOther(String password){
		navigateToAccount.goToRegistrationPage();
		typePassword(password);
		typeConfirmPassword(password);
		assertmatchingPasswords();
	}
	
	@Step
	public void assertNotMatchingPasswords(){
		registration.passwordsNotMatching();
	}
	
	@StepGroup
	public void checkNotMatchingPasswordsAgainstEachOther(String password){
		navigateToAccount.goToRegistrationPage();
		typePassword(password);
		typeConfirmPassword("victortomaciprian@gmail.com");
		assertNotMatchingPasswords();
	}
	
	@Step
	public void clickOnPassworInput(){
		registration.clickOnPasswordInput();
	}
	
	@Step
	public void checkThatSuggestionsAppear(boolean shouldAppear, String... suggestions) {
		registration.checkThatSuggestionsAppear(shouldAppear, suggestions);
	}
}
