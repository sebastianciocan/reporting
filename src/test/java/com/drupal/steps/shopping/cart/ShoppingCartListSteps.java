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
	
//	@Step
//	 public void checkDetailValue(String productCode, String detailName, String expectedDetailValue){
//		shoppingCartPage.checkDetailValue( productCode,  detailName,  expectedDetailValue);
//	}
	
	@Step
	public void checkQuantityValue(String productCode, Float expectedDetailValue) {
		shoppingCartPage.checkQuantityValue( productCode,  expectedDetailValue);
	}	
	
	@Step
	public void checkPriceValue(String productCode, Float expectedDetailValue) {
		shoppingCartPage.checkPriceValue( productCode,  expectedDetailValue);
			
	}
	
	@Step	
	public void checkTotalPriceValue(String productCode){
		shoppingCartPage.checkTotalPriceValue( productCode);
	}
	 @Step
	public void checkOrderTotalPrice(){
		 shoppingCartPage.checkOrderTotalPrice();
	 }
	
}
