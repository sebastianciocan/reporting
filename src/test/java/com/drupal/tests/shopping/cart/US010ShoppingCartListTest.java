package com.drupal.tests.shopping.cart;

import com.drupal.steps.shopping.cart.ShoppingCartListSteps;
import tools.Constants;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import tools.Helpers;
import com.drupal.pages.cart.ShoppingCartPage;
import com.drupal.steps.navigation.NavigationSteps;
import com.drupal.steps.product.AllProductsSteps;
import com.drupal.steps.product.SpecifiedProductSteps;
import com.drupal.tests.BaseTest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class US010ShoppingCartListTest extends BaseTest {

	public String productName1 = "";
	public String productName2 = "";
	public String productQuanity1 = "";
	public String productQuanity2 = "";

	@Before
	public void setup() {

		
		productName1 = "Drupal Commerce Ready for the Court";
		productName2 = "\"The Guy\" Mug";
		webdriver.manage().window().maximize();
		productQuanity1 = "3";
		productQuanity2 = "2";
		Helpers helpers = new Helpers();

		navigationSteps.navigateTo(Constants.HOST);
		navigationSteps.selectProductCategoryFromMenuList(Constants.ALLPRODUCTSMENUITEM);
		allProductsSteps.selectSpecifiedProduct(productName1);
		specifiedProductSteps.checkIfThePathToTheProductIsCorrect(productName1);
		String productSkuFromProductPage1 = specifiedProductSteps.getProductCode();
		String productPriceFromProductPage1 = helpers.removeCharacters(specifiedProductSteps.getProductPrice());
		double productDefaultPrice1 = Double.parseDouble(productPriceFromProductPage1);
		specifiedProductSteps.clickReadMoreDescriptionButton();
		specifiedProductSteps.clickIncreaseProductQuantityBy1();
		specifiedProductSteps.clickIncreaseProductQuantityBy1();
		specifiedProductSteps.clickAddToCartButton();
		String popupProductSku1 = helpers.replaceNewLineFromStringWithSpace(specifiedProductSteps.getPopUpProductSku());
		String popUpProductQuantity1 = specifiedProductSteps.getPopUpProductQuantity();
		String popUpTotalPrice1 = helpers.removeCharacters(specifiedProductSteps.getPopUpTotalPrice());
		double totalProductPrice1 = Double.parseDouble(popUpTotalPrice1);
		helpers.assertProductDetails(productSkuFromProductPage1,popupProductSku1,productQuanity1,popUpProductQuantity1,productDefaultPrice1,totalProductPrice1);
		specifiedProductSteps.createAProductDetailsList();
		specifiedProductSteps.clickContinueShoppingButton();
		navigationSteps.selectProductCategoryFromMenuList(Constants.ALLPRODUCTSMENUITEM);
		allProductsSteps.selectSpecifiedProduct(productName2);
		specifiedProductSteps.checkIfThePathToTheProductIsCorrect(productName2);
		String productSkuFromProductPage2 = specifiedProductSteps.getProductCode();
		String productPriceFromProductPage2 = helpers.removeCharacters(specifiedProductSteps.getProductPrice());
		double productDefaultPrice2 = Double.parseDouble(productPriceFromProductPage2);
		specifiedProductSteps.clickReadMoreDescriptionButton();
		specifiedProductSteps.clickIncreaseProductQuantityBy1();
		specifiedProductSteps.clickAddToCartButton();
		String popupProductSku2 = helpers.replaceNewLineFromStringWithSpace(specifiedProductSteps.getPopUpProductSku());
		String popUpProductQuantity2 = specifiedProductSteps.getPopUpProductQuantity();
		String popUpTotalPrice2 = helpers.removeCharacters(specifiedProductSteps.getPopUpTotalPrice());
		double totalProductPrice2 = Double.parseDouble(popUpTotalPrice2);
		helpers.assertProductDetails(productSkuFromProductPage2,popupProductSku2,productQuanity2,popUpProductQuantity2,productDefaultPrice2,totalProductPrice2);
		specifiedProductSteps.createAProductDetailsList();
		specifiedProductSteps.clickGoToCheckoutButton();

	}

	@Steps
	public AllProductsSteps allProductsSteps;
	@Steps
	public NavigationSteps navigationSteps;
	@Steps
	public SpecifiedProductSteps specifiedProductSteps;
	@Steps
	public ShoppingCartPage shoppingCartPage;

	@Steps
	private ShoppingCartListSteps shoppingCartListSteps;

	@Test
	public void testName() {

		shoppingCartListSteps.checkPropertyValue("SHO2-PRL-04", "Color", "Purple");
		shoppingCartListSteps.checkDetailValue("SHO2-PRL-04", "QUANTITY", "3");
		shoppingCartListSteps.checkPropertyValue("MG2-YLW-OS", "Color", "Yellow");
		shoppingCartListSteps.checkDetailValue("MG2-YLW-OS", "QUANTITY", "2");
	}

}
