package com.drupal.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class Utils {
	@FindBy(css = ".button.checkout>a")
	WebElement goToCheckoutItem;

	@FindBy(id = "#edit-submit")
	WebElement addToCartItem;

	@FindBy(css = "div.button.continue .commerce-add-to-cart-confirmation-close")
	WebElement continueShoppingItem;

}
