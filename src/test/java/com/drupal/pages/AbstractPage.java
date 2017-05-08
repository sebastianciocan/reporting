package com.drupal.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public abstract class AbstractPage extends PageObject {

	public AbstractPage() {

	}

	public static void clickAMenuItemFromList(WebElement webElement, String setTextSearch) {
		List<WebElement> itemList = webElement.findElements(By.tagName("li"));

		for (WebElement element : itemList) {
			if (element.findElement(By.cssSelector("a")).getText().contains(setTextSearch)) {
				element.findElement(By.cssSelector("a")).click();
				break;
			}
		}
	}



	WebDriver driver;

	protected WebElement findElementInList(List<WebElement> listElements, String searchTerm) {
		for (WebElement webElement : listElements) {
			if (webElement.getText().trim().contentEquals(searchTerm)) {
				return webElement;
			}
		}
		return null;
	}

	protected void waitForPageToLoad() {
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
	}

}


