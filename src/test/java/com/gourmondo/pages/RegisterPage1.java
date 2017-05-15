package com.gourmondo.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.drupal.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class RegisterPage1 extends AbstractPage {

	@FindBy(id = "log-in")
	WebElement loginItem;

	@FindBy(css = "#switch-to-register")
	WebElement swichToRegisterItem;

	@FindBy(css = "#privateClient")
	WebElement privateClientRadioButton;

	@FindBy(css = ".btn.dropdown-toggle.selectpicker.btn-default[title='Frau']")
	WebElement genderDropDownButton;

	@FindBy(css = "#registerClientForm-firstName[name=firstName]")
	WebElement firstnameInput;

	@FindBy(css = "#registerClientForm-lastName[name='lastName']")
	WebElement lastnameInput;

	@FindBy(css = "#registerClientForm-email[name='email']")
	WebElement emailInput;

	@FindBy(css = "#registerClientForm-birthDay .SelectDate:nth-of-type(1) div[class='btn-group bootstrap-select  select-picker-wrapper']")
	private WebElement dayDropDown;

	@FindBy(css = "#registerClientForm-birthDay .SelectDate:nth-of-type(1) .dropdown-menu.inner.selectpicker")
	private WebElement daysList;

	@FindBy(css = "#registerClientForm-birthDay .SelectDate:nth-of-type(2) div[class='btn-group bootstrap-select  select-picker-wrapper']")
	private WebElement monthDropDown;

	@FindBy(css = "#registerClientForm-birthDay .SelectDate:nth-of-type(2) .dropdown-menu.inner.selectpicker")
	private WebElement monthsList;

	@FindBy(css = "#registerClientForm section.SelectDate:nth-child(3)")
	private WebElement yearDropDown;

	@FindBy(css = "#registerClientForm-birthDay .SelectDate:nth-of-type(3) .dropdown-menu.inner.selectpicker")
	private WebElement yearsList;

	@FindBy(id = "registerClientForm-password")
	WebElement passwordInput;

	@FindBy(css = "#registerClientForm-checkPwd[name='checkPwd']")
	WebElement confirmPasswordInput;

	@FindBy(css = "label[for='registerClientForm-termsConditionsCheck']>span")
	WebElement jaCheckBox;

	@FindBy(css = "#registerClientForm div.submit-button button")
	WebElement submitButton;
	//.values .submit-button .btn.btn-lg.btn-primary.text-uppercase
	
	

	public void clicktoLoginItem() {
		element(loginItem).waitUntilVisible();
		loginItem.click();
	}

	public void clicktoSwichtoRegisterItem() {
		swichToRegisterItem.click();
	}

	public void clickToPrivateClient() {
		privateClientRadioButton.click();
	}

	public void selectGender() {
		genderDropDownButton.click();
	}

	public void typeFirstName(String firstname) {
		firstnameInput.clear();
		firstnameInput.sendKeys(firstname);
	}

	public void typeLastName(String lastName) {
		lastnameInput.clear();
		lastnameInput.sendKeys(lastName);

	}

	public void typeEmail(String email) {
		emailInput.clear();
		emailInput.sendKeys(email);
	}

	public void selectDay(String day) {

		dayDropDown.click();
		element(daysList).waitUntilVisible();
		List<WebElement> daysLists = daysList.findElements(By.cssSelector("li"));

		for (WebElement selectDay : daysLists) {
			if (selectDay.findElement(By.cssSelector("a span")).getText().contentEquals(day)) {
				selectDay.click();
			}
		}
	}

	public void selectMonth(String month) {

		monthDropDown.click();
		element(monthsList).waitUntilVisible();
		List<WebElement> monthList = monthsList.findElements(By.cssSelector("li"));

		for (WebElement selectMonth : monthList) {
			if (selectMonth.findElement(By.cssSelector("a span")).getText().contentEquals(month)) {
				selectMonth.click();
			}
		}
	}

	public void selectYear(String year) {

		yearDropDown.click();
		element(yearsList).waitUntilVisible();
		List<WebElement> yearList = yearsList.findElements(By.cssSelector("li"));

		for (WebElement selectYear : yearList) {
			if (selectYear.findElement(By.cssSelector("a span")).getText().contentEquals(year)) {
				selectYear.click();
			}
		}
	}

	public void setThePassword(String password) {
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}

	public void confirmPassword(String confirmPass) {
		confirmPasswordInput.clear();
		confirmPasswordInput.sendKeys(confirmPass);
	}

	public void checkTheJaCheckBox() {
		jaCheckBox.click();
	}

	public void clickTSubmit() {
		element(submitButton).waitUntilVisible();
		submitButton.click();
	}
}
