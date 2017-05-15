package com.gourmondo.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.gourmondo.steps.RegisterSteps1;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)

public class RegisterTest1 {
	@Managed(uniqueSession = true)
	WebDriver webdriver;
	
	@Before
	public void dataSetup() {
		webdriver.get("https://test-de.gourmondo.evozon.com:9002/");
	}

	@Steps
	public RegisterSteps1 registerSteps1;

	@Test
	public void createAnAccountTest() {
		
		registerSteps1.clickToLoginItem();
		registerSteps1.clicktoSwichtoRegisterItem();
		//registerSteps1.clickToPrivateClient();
//		registerSteps1.selectGender();
		registerSteps1.typeFirstName("firstname");
		registerSteps1.typeLastName("lastname");
		registerSteps1.typeEmail("gourmondoevotest@gmail.com");
	
		registerSteps1.selectDay("02");
		registerSteps1.selectMonth("03");
		registerSteps1.selectYear("1980");
		registerSteps1.setThePassword("Gourmondo.test");
		registerSteps1.confirmPassword("Gourmondo.test");
		registerSteps1.checkTheJaCheckBox();
		registerSteps1.clickTSubmit();
		
	}

}
