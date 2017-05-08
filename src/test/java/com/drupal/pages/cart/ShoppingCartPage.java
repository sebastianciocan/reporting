package com.drupal.pages.cart;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.drupal.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class ShoppingCartPage extends AbstractPage {

	@FindBy(css = ".field.field-name-title-field.field-type-text.field-label-hidden>a")
	WebElement laptopBagItem;

	@FindBy(css = ".field.field-name-title-field.field-type-text.field-label-hidden>a")
	WebElement commerceToWakeYouUpItem;

	WebElement priceItem;
	WebElement quantityItem;
	WebElement totalPricePerProduct;
	WebElement viewProductItem;
	WebElement SKUItem;
	WebElement sizeItem;
	WebElement colorItem;

	List<Package> shoppingCartList = new ArrayList<Package>();

	public ShoppingCartPage(WebElement priceItem, WebElement quantityItem, WebElement totalPricePerProduct,
			WebElement viewProductItem, WebElement SKUItem, WebElement sizeItem, WebElement colorItem) {
		this.priceItem = priceItem;
		this.quantityItem = quantityItem;
		this.totalPricePerProduct = totalPricePerProduct;
		this.viewProductItem = viewProductItem;
		this.SKUItem = SKUItem;
		this.sizeItem = sizeItem;
		this.colorItem = colorItem;

	}
}
