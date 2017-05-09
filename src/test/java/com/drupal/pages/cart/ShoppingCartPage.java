package com.drupal.pages.cart;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.drupal.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ShoppingCartPage extends AbstractPage {
	WebDriver driver;

	@FindBy(css = ".field.field-name-title-field.field-type-text.field-label-hidden>a")
	WebElement laptopBagItem;

	@FindBy(css = ".field.field-name-title-field.field-type-text.field-label-hidden>a")
	WebElement commerceToWakeYouUpItem;

	public WebElement getShoppingCartItem(String productCode) {

		List<WebElement> cartListElements = getDriver().findElements(By.cssSelector(".views-table.cols-5 tr"));
		for (WebElement productRowNow : cartListElements) {
			if (productRowNow.findElement(By.cssSelector(".commerce-product-sku")).getText().toLowerCase()
					.contentEquals(productCode.toLowerCase())) {
				return productRowNow;
			}
		}
		return null;
	}

	public String getPropertyValue(String productCode, String propertyName) {
		boolean isPropertyFound = false;
		WebElement shoppingCartItem = getShoppingCartItem(productCode);
		List<WebElement> propertiesList = shoppingCartItem.findElements(By.cssSelector(".content div[class*='field-name']"));
		for (WebElement propertyItem : propertiesList) {
			propertyItem.getText().toLowerCase().contains(propertyName.toLowerCase() + ":");
			String propertyParts[] = propertyItem.getText().split(": ");
			return propertyParts[1];
		}
		Assert.assertTrue("The property was not found!", isPropertyFound);
		return null;
	}
	
	public void checkPropertyValue(String productCode, String propertyName, String expectedPropertyValue){
		Assert.assertTrue("The property value is incorrect!", getPropertyValue(productCode, propertyName).contentEquals(expectedPropertyValue));
		
	}
	
	public String getProductDetailValue(String productCode, String detailName) {
		WebElement shoppingCartItem = getShoppingCartItem(productCode);
		return shoppingCartItem.findElement(By.cssSelector("td[class*='"+detailName.toLowerCase()+"']")).getAttribute("value");

	}	
	
	public void checkDetailValue(String productCode, String detailName, String expectedDetailValue){
		Assert.assertTrue("The detail value is incorrect!", getProductDetailValue(productCode, detailName).contentEquals(expectedDetailValue));
		
	}

}
