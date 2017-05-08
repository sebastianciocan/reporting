package com.drupal.tests.account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.drupal.steps.navigation.NavigationSteps;
import com.drupal.tests.BaseTest;
import com.wiki.steps.EndUserSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import tools.Constants;
import tools.RandomData;



@RunWith(SerenityRunner.class)
public class US001CreateAccountTest extends BaseTest{
	

    @Steps
    public EndUserSteps endUserSteps;
    @Steps
    public NavigationSteps navigationSteps;
    

    public String url;
    public String userName;
    public String userEmail;
    public String userPassword;
    
    
    @Before
    public void dataSetup(){
    	url = Constants.HOST;
    	/*
    	userName = RandomData.getUniqueString(5, 9);
    	userEmail =  RandomData.getUniqueString(5, 9);
    	userPassword = RandomData.getUniquePassword();
    	*/
    	userName = "victor";
    	userEmail = "victortomaciprian@gmail.com";
    	userPassword = "Pass_569";
    }

    
    @Test
    public void us001CreateAccountTest(){
    	navigationSteps.navigateTo(url);
    }
}
