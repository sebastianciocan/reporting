package com.drupal.tests.account;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.drupal.steps.RegistrationSteps;
import com.drupal.steps.UserZoneSteps;
import com.drupal.steps.navigation.NavigationSteps;
import com.drupal.tests.BaseTest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import tools.Constants;

import tools.RandomData;

@RunWith(SerenityRunner.class)
public class US001CreateAccountTest extends BaseTest{
	

    @Steps
    public RegistrationSteps registrationSteps;
    @Steps
    public UserZoneSteps createAccountSteps;
    @Steps
    public NavigationSteps navigationSteps;
    

    public String userName;
    public String userEmail;
    public String userPassword;
    
    public String existingUserName;
    public String existingEmail;
    
    
    @Before
    public void dataSetup(){
    	
    	userName = RandomData.getUniqueString(5, 9);
    	userEmail =  RandomData.getUniqueGmail("victortomaciprian") ;
    	userPassword = RandomData.getUniquePassword();
    	
    }
    @Ignore
    @Test
    public void us001CreateAccountTest(){
    	
    	navigationSteps.navigateTo(Constants.HOST);
    	registrationSteps.performRegistration(userName, userEmail, userPassword);
    	
    }
    
    @Ignore
    @Test
    public void us002CreateAccountWithExistingUserNameTest(){
    	navigationSteps.navigateTo(Constants.HOST);
    	registrationSteps.registerWithExistingUserName("victor", userEmail, userPassword);
    }
    
    @Ignore
    @Test
    public void us003CreateAccountWithExistingEmailTest(){
    	navigationSteps.navigateTo(Constants.HOST);
    	registrationSteps.registerWithExistingEmail(userName, "victortomaciprian@gmail.com", userPassword);;
    }
    
    @Ignore
    @Test 
    public void us004RecoverPasswordTest(){
    	navigationSteps.navigateTo(Constants.HOST);
    	createAccountSteps.goToRegistrationPage();
    	registrationSteps.typeUsername(userName);
    	registrationSteps.typeEmail("victortomaciprian@gmail.com");
    	registrationSteps.typePassword(userPassword);
    	registrationSteps.typeConfirmPassword(userPassword);
    	registrationSteps.clickCreateNewAccountButton();
    	registrationSteps.clickRecoverPasswordLink();
    	registrationSteps.typeEmailForPasswordRecovery("victortomaciprian@gmail.com");
    	registrationSteps.clickSendEmailForPasswordRecoveryButton();
    	registrationSteps.assertEmailIsSent();
    }
    
    @Test
    public void us005CreateAccountWithoutUserNameTest(){
    	navigationSteps.navigateTo(Constants.HOST);
    	registrationSteps.registerWithoutAnUsername(userEmail, userPassword);
    }
    
    @Test
    public void us006CreateAccountWithoutEmailTest(){
    	navigationSteps.navigateTo(Constants.HOST);
    	registrationSteps.registerWithoutAnEmail(userName, userPassword);
    	
    }
    
    @Test
    public void us007VerifyMatchingPasswordsTest(){
    	navigationSteps.navigateTo(Constants.HOST);
    	registrationSteps.checkMatchingPasswordsAgainstEachOther(userPassword);
    }
    
    @Test
    public void us008VerifyNotMatchingPasswordsTest(){
    	navigationSteps.navigateTo(Constants.HOST);
    	registrationSteps.checkNotMatchingPasswordsAgainstEachOther(userPassword);
    }
    
    
}
