package com.drupal.steps.navigation;

import com.drupal.pages.header.MenuNavigationPage;
import com.drupal.steps.AbstractSteps;
import net.thucydides.core.annotations.Step;

public class NavigationSteps extends AbstractSteps{
	private static final long serialVersionUID = 1L;

	MenuNavigationPage menuNavigationPage;

	@Step
	public void selectProductCategoryFromMenuList(String menuItem){
		menuNavigationPage.selectACategoryFromMainMenu(menuItem);
	}
	
}
