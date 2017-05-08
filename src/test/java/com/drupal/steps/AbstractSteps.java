package com.drupal.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AbstractSteps extends ScenarioSteps{

	private static final long serialVersionUID = 1L;

	
	
	@Step
	public void navigateTo(String url){
		getDriver().get(url);
	}
}
