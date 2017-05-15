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

		List<WebElement> cartListElements = getDriver().findElements(By.cssSelector(".views-table.cols-5 tbody tr"));
		for (WebElement productRowNow : cartListElements) {
			if (productRowNow.findElement(By.cssSelector(".commerce-product-sku")).getText().toLowerCase()
					.contains(productCode.toLowerCase())) {
				return productRowNow;
			}
		}
		return null;
	}

	public String getPropertyValue(String productCode, String propertyName) {
		boolean isPropertyFound = false;
		WebElement shoppingCartItem = getShoppingCartItem(productCode);
		List<WebElement> propertiesList = shoppingCartItem
				.findElements(By.cssSelector(".content div[class*='field-name']"));
		for (WebElement propertyItem : propertiesList) {
			if (propertyItem.getText().toLowerCase().contains(propertyName.toLowerCase() + ":")) {
				String propertyParts[] = propertyItem.getText().split(": ");
				return propertyParts[1];
			}
		}
		Assert.assertTrue("The property was not found!", isPropertyFound);
		return null;
	}

	public void checkPropertyValue(String productCode, String propertyName, String expectedPropertyValue) {
		Assert.assertTrue("The property value is incorrect!",
				getPropertyValue(productCode, propertyName).contains(expectedPropertyValue));

	}

	public String getProductDetailValue(String productCode, String detailCssSelector) {
		WebElement shoppingCartItem = getShoppingCartItem(productCode);
		if (shoppingCartItem.findElement(By.cssSelector(detailCssSelector)).getAttribute("value") == null)
			return shoppingCartItem.findElement(By.cssSelector(detailCssSelector)).getText();
		else
			return shoppingCartItem.findElement(By.cssSelector(detailCssSelector)).getAttribute("value");
	}

	public Float getQuantityValue(String productCode) {
		return Float.parseFloat(getProductDetailValue(productCode, "td[class*='quantity'] input"));
	}

	public Float getPriceValue(String productCode) {

		return Float.parseFloat(getProductDetailValue(productCode, "td[class*='unit-price']").replace("$", ""));
	}

	public void checkQuantityValue(String productCode, Float expectedDetailValue) {
		Assert.assertTrue("The quantity value is incorrect!",
				getQuantityValue(productCode).equals(expectedDetailValue));
	}

	public void checkPriceValue(String productCode, Float expectedDetailValue) {

		Assert.assertTrue("The price value is incorrect!", getPriceValue(productCode).equals(expectedDetailValue));
	}

	public Float getTotalPriceValue(String productCode) {
		return Float
				.parseFloat(getProductDetailValue(productCode, "td[class*='total']").replace("$", "").replace(" ", ""));
	}

	public void checkTotalPriceValue(String productCode) {
		Assert.assertTrue("The total price value is incorrect",
				(getPriceValue(productCode) * getQuantityValue(productCode)) == (getTotalPriceValue(productCode)));
	}

	public Float getOrderTotalPricesSum() {
		Float totalPrice = 0f;
		List<WebElement> cartListElements = getDriver().findElements(By.cssSelector(".views-table.cols-5 tbody tr"));
		String pricePerProduct = null;
		for (WebElement productRowNow : cartListElements) {
			pricePerProduct = productRowNow.findElement(By.cssSelector(("td[class*='total']"))).getText()
					.replace("$", "").replace(" ", "");
			totalPrice += Float.parseFloat(pricePerProduct);

		}

		return totalPrice;
	}

	public void checkOrderTotalPrice() {
		String totalOrderPrice = getDriver()
				.findElement(By.cssSelector(".component-type-commerce-price-formatted-amount.odd")).getText()
				.replace("Order total $", "");

		Float totalPrice = Float.parseFloat(totalOrderPrice);
		Assert.assertTrue("The order total price value is incorrect", (getOrderTotalPricesSum().equals(totalPrice)));

	}

}
