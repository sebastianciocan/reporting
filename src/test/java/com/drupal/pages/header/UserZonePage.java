package com.drupal.pages.header;

import org.openqa.selenium.WebElement;

import com.drupal.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import tools.Constants;

public class UserZonePage extends AbstractPage {
	
	@FindBy(css = "li.last.leaf a[href=\"/user/register\"]")
	WebElement createAccountLink;
	
	
	public void goToRegistrationPage(){
		createAccountLink.click();
	}
	
}
