package com.gourmondo.steps;

import com.gourmondo.pages.RegisterPage1;

import net.thucydides.core.annotations.Step;

public class RegisterSteps1 {

	RegisterPage1 registerPage1;

	@Step
	public void clickToLoginItem() {
		registerPage1.clicktoLoginItem();
	}

	@Step
	public void clicktoSwichtoRegisterItem() {
		registerPage1.clicktoSwichtoRegisterItem();
	}

//	@Step
//	public void clickToPrivateClient() {
//		registerPage1.clickToPrivateClient();
//	}

//	@Step
//	public void selectGender() {
//		registerPage1.selectGender();
//	}

	@Step
	public void typeFirstName(String firstname) {
		registerPage1.typeFirstName(firstname);
	}

	@Step
	public void typeLastName(String lastName) {
		registerPage1.typeLastName(lastName);
	}

	@Step
	public void typeEmail(String email) {
		registerPage1.typeEmail(email);
	}

	@Step
	public void selectDay(String day) {
		registerPage1.selectDay(day);
	}

	@Step
	public void selectMonth(String month) {
		registerPage1.selectMonth(month);
	}

	@Step
	public void selectYear(String year) {
		registerPage1.selectYear(year);
	}

	@Step
	public void setThePassword(String password) {
		registerPage1.setThePassword(password);
	}

	@Step
	public void confirmPassword(String confirmPass) {
		registerPage1.confirmPassword(confirmPass);
	}

	@Step
	public void checkTheJaCheckBox() {
		registerPage1.checkTheJaCheckBox();
	}

	@Step
	public void clickTSubmit() {
		registerPage1.clickTSubmit();
	}
}
