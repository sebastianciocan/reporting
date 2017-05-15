package com.drupal.pages.header;

import org.openqa.selenium.WebElement;

import com.drupal.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import tools.Constants;

public class UserZonePage extends AbstractPage {
	
	@FindBy(css = "li.last.leaf a")
	WebElement createAccountLink;
	//@FindBy(css = "div#block-menu-menu-user-menu div.block-inner.clearfix div.content.clearfix ul.menu li.first.leaf a")
	WebElement logInLink;
	
	public void goToRegistrationPage(){
		createAccountLink.click();
	}
	
	public  void goToLoginPage(){
		logInLink.click();
	}
	
}
