//package com.drupal.tests.account;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import com.drupal.steps.RegistrationSteps;
//import com.drupal.steps.UserZoneSteps;
//import com.drupal.steps.navigation.NavigationSteps;
//import com.drupal.tests.BaseTest;
//
//import net.serenitybdd.junit.runners.SerenityRunner;
//import net.thucydides.core.annotations.Steps;
//import tools.Constants;
//
//import tools.RandomData;
//
//@RunWith(SerenityRunner.class)
//public class US001CreateAccountTest extends BaseTest{
//
//
//    @Steps
//    public RegistrationSteps registrationSteps;
//    @Steps
//    public UserZoneSteps createAccountSteps;
//    @Steps
//    public NavigationSteps navigationSteps;
//
//
//    public String userName;
//    public String userEmail;
//    public String userPassword;
//
//    public String existingUserName;
//    public String existingEmail;
//
//
//    @Before
//    public void dataSetup(){
//
//    	userName = RandomData.getUniqueString(5, 9);
//    	userEmail =  RandomData.getUniqueGmail("victortomaciprian") ;
//    	userPassword = RandomData.getUniquePassword();
//
//    }
//    @Ignore
//    @Test
//    public void us001CreateAccountTest(){
//
//    	navigationSteps.navigateTo(Constants.HOST);
//    	registrationSteps.performRegistration(userName, userEmail, userPassword);
//
//    }
//
//    @Ignore
//    @Test
//    public void us002CreateAccountWithExistingUserNameTest(){
//    	navigationSteps.navigateTo(Constants.HOST);
//    	registrationSteps.registerWithExistingUserName("victor", userEmail, userPassword);
//    }
//
//    @Ignore
//    @Test
//    public void us003CreateAccountWithExistingEmailTest(){
//    	navigationSteps.navigateTo(Constants.HOST);
//    	registrationSteps.registerWithExistingEmail(userName, "victortomaciprian@gmail.com", userPassword);;
//    }
//
//    @Ignore
//    @Test
//    public void us004RecoverPasswordTest(){
//    	navigationSteps.navigateTo(Constants.HOST);
//    	createAccountSteps.goToRegistrationPage();
//    	registrationSteps.typeUsername(userName);
//    	registrationSteps.typeEmail("victortomaciprian@gmail.com");
//    	registrationSteps.typePassword(userPassword);
//    	registrationSteps.typeConfirmPassword(userPassword);
//    	registrationSteps.clickCreateNewAccountButton();
//    	registrationSteps.clickRecoverPasswordLink();
//    	registrationSteps.typeEmailForPasswordRecovery("victortomaciprian@gmail.com");
//    	registrationSteps.clickSendEmailForPasswordRecoveryButton();
//    	registrationSteps.assertEmailIsSent();
//    }
//
//    @Ignore
//    @Test
//    public void us005CreateAccountWithoutUserNameTest(){
//    	navigationSteps.navigateTo(Constants.HOST);
//    	registrationSteps.registerWithoutAnUsername(userEmail, userPassword);
//    }
//
//    @Ignore
//    @Test
//    public void us006CreateAccountWithoutEmailTest(){
//    	navigationSteps.navigateTo(Constants.HOST);
//    	registrationSteps.registerWithoutAnEmail(userName, userPassword);
//
//    }
//
//    @Ignore
//    @Test
//    public void us007VerifyMatchingPasswordsTest(){
//    	navigationSteps.navigateTo(Constants.HOST);
//    	registrationSteps.checkMatchingPasswordsAgainstEachOther(userPassword);
//    }
//
//    @Ignore
//    @Test
//    public void us008VerifyNotMatchingPasswordsTest(){
//    	navigationSteps.navigateTo(Constants.HOST);
//    	registrationSteps.checkNotMatchingPasswordsAgainstEachOther(userPassword);
//    }
//
//    @Ignore
//    @Test
//    public void us009VerifyUppercaseTest(){
//    	navigationSteps.navigateTo(Constants.HOST);
//    	createAccountSteps.goToRegistrationPage();
//    	registrationSteps.clickOnPassworInput();
//    	registrationSteps.checkThatSuggestionsAppear(true, "Make it at least 6 characters","Add lowercase letters","Add uppercase letters",
//    												"Add numbers","Add punctuation");
//    	registrationSteps.typePassword("P");
//    	registrationSteps.checkThatSuggestionsAppear(false, "Add uppercase letters");
//    }
//    @Ignore
//    @Test
//    public void us009VerifyMinimumLengthTest(){
//    	navigationSteps.navigateTo(Constants.HOST);
//    	createAccountSteps.goToRegistrationPage();
//    	registrationSteps.clickOnPassworInput();
//    	registrationSteps.checkThatSuggestionsAppear(true, "Make it at least 6 characters","Add lowercase letters","Add uppercase letters",
//    												"Add numbers","Add punctuation");
//    	registrationSteps.typePassword("passwo");
//    	registrationSteps.checkThatSuggestionsAppear(false, "Make it at least 6 characters");
//    }
//
//    @Ignore
//    @Test
//    public void us010VerifyLowerCaseSuggestionTest(){
//    	navigationSteps.navigateTo(Constants.HOST);
//    	createAccountSteps.goToRegistrationPage();
//    	registrationSteps.clickOnPassworInput();
//    	registrationSteps.checkThatSuggestionsAppear(true, "Make it at least 6 characters","Add lowercase letters","Add uppercase letters",
//    												"Add numbers","Add punctuation");
//    	registrationSteps.typePassword("p");
//    	registrationSteps.checkThatSuggestionsAppear(false, "Add lowercase letters");
//    }
//    @Ignore
//    @Test
//    public void us12VerifyNumbersSuggestionTest(){
//    	navigationSteps.navigateTo(Constants.HOST);
//    	navigationSteps.navigateTo(Constants.HOST);
//    	createAccountSteps.goToRegistrationPage();
//    	registrationSteps.clickOnPassworInput();
//    	registrationSteps.checkThatSuggestionsAppear(true, "Make it at least 6 characters","Add lowercase letters","Add uppercase letters",
//    												"Add numbers","Add punctuation");
//    	registrationSteps.typePassword("1");
//    	registrationSteps.checkThatSuggestionsAppear(false, "Add numbers");
//    }
//    @Ignore
//    @Test
//    public void us13VerifyPunctuationSuggestionTest(){
//    	navigationSteps.navigateTo(Constants.HOST);
//    	navigationSteps.navigateTo(Constants.HOST);
//    	createAccountSteps.goToRegistrationPage();
//    	registrationSteps.clickOnPassworInput();
//    	registrationSteps.checkThatSuggestionsAppear(true, "Make it at least 6 characters","Add lowercase letters","Add uppercase letters",
//    												"Add numbers","Add punctuation");
//    	registrationSteps.typePassword("_");
//    	registrationSteps.checkThatSuggestionsAppear(false, "Add punctuation");
//    }
//    @Ignore
//    @Test
//    public void us14VerifyNoSuggestionsAppearTest(){
//    	navigationSteps.navigateTo(Constants.HOST);
//    	navigationSteps.navigateTo(Constants.HOST);
//    	createAccountSteps.goToRegistrationPage();
//    	registrationSteps.clickOnPassworInput();
//    	registrationSteps.checkThatSuggestionsAppear(true, "Make it at least 6 characters","Add lowercase letters","Add uppercase letters",
//    												"Add numbers","Add punctuation");
//    	registrationSteps.typePassword(userPassword);
//    	registrationSteps.checkThatSuggestionsAppear(false, "Make it at least 6 characters","Add lowercase letters","Add uppercase letters",
//				"Add numbers","Add punctuation");
//
//    }
//
//}
