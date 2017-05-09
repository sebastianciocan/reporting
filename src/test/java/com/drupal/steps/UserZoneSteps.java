package com.drupal.steps;

import com.drupal.pages.header.UserZonePage;

public class UserZoneSteps {
	private static final long serialVersionUID =1L;
	UserZonePage userZone; 
	
	public void goToRegistrationPage(){
		userZone.goToRegistrationPage();
	}
}
