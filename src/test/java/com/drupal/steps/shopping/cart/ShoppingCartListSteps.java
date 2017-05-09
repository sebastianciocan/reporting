package com.drupal.steps.shopping.cart;

import com.drupal.pages.cart.ShoppingCartPage;
import com.drupal.steps.AbstractSteps;

import net.thucydides.core.annotations.Step;

public class ShoppingCartListSteps extends AbstractSteps {

	
	
	private ShoppingCartPage shoppingCartPage;
	
	@Step
	 public void checkPropertyValue(String productCode, String propertyName, String expectedPropertyValue){
		shoppingCartPage.checkPropertyValue(productCode, propertyName, expectedPropertyValue);
	}
	
	@Step
	 public void checkDetailValue(String productCode, String detailName, String expectedDetailValue){
		shoppingCartPage.checkDetailValue( productCode,  detailName,  expectedDetailValue);
	}
	
	
}
