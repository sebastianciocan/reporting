package com.drupal.tests.product;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
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
public class US002AddTwoProductsToCartTest extends BaseTest {
    public String productName1,productName2,productQuanity1,productQuanity2;
    public String productSkuFromProductPage1,productPriceFromProductPage1,popupProductSku1,popUpProductQuantity1,popUpTotalPrice1;
    public double productDefaultPrice1,totalProductPrice1;
    public String productSkuFromProductPage2,productPriceFromProductPage2,popupProductSku2,popUpProductQuantity2,popUpTotalPrice2;
    public double productDefaultPrice2,totalProductPrice2;



    @Before
    public void setup(){
        productName1 = "Drupal Commerce Ready for the Court";
        productName2 = "\"The Guy\" Mug";
        webdriver.manage().window().maximize();
        productQuanity1 = "3";
        productQuanity2 = "2";

    }

    @Steps
    public AllProductsSteps allProductsSteps;
    @Steps
    public NavigationSteps navigationSteps;
    @Steps
    public SpecifiedProductSteps specifiedProductSteps;
    @Steps
    public ShoppingCartPage shoppingCartPage;

    @Test
    public void addTwoProductsToCartFromProductPage(){
        Helpers helpers = new Helpers();


        navigationSteps.navigateTo(Constants.HOST);
        navigationSteps.selectProductCategoryFromMenuList(Constants.ALLPRODUCTSMENUITEM);
        allProductsSteps.selectSpecifiedProduct(productName1);
        specifiedProductSteps.checkIfThePathToTheProductIsCorrect(productName1);
        productSkuFromProductPage1 = specifiedProductSteps.getProductCode();
        productPriceFromProductPage1 = helpers.removeCharacters(specifiedProductSteps.getProductPrice());
        productDefaultPrice1 = Double.parseDouble(productPriceFromProductPage1);
        specifiedProductSteps.clickReadMoreDescriptionButton();
        specifiedProductSteps.clickIncreaseProductQuantityBy1();
        specifiedProductSteps.clickIncreaseProductQuantityBy1();
        specifiedProductSteps.clickAddToCartButton();
        popupProductSku1 = helpers.replaceNewLineFromStringWithSpace(specifiedProductSteps.getPopUpProductSku());
        popUpProductQuantity1 = specifiedProductSteps.getPopUpProductQuantity();
        popUpTotalPrice1 = helpers.removeCharacters(specifiedProductSteps.getPopUpTotalPrice());
        totalProductPrice1 = Double.parseDouble(popUpTotalPrice1);
        helpers.assertProductDetails(productSkuFromProductPage1,popupProductSku1,productQuanity1,popUpProductQuantity1,productDefaultPrice1,totalProductPrice1);
        specifiedProductSteps.createAProductDetailsList();
        specifiedProductSteps.clickContinueShoppingButton();
        navigationSteps.selectProductCategoryFromMenuList(Constants.ALLPRODUCTSMENUITEM);
        allProductsSteps.selectSpecifiedProduct(productName2);
        specifiedProductSteps.checkIfThePathToTheProductIsCorrect(productName2);
        productSkuFromProductPage2 = specifiedProductSteps.getProductCode();
        productPriceFromProductPage2 = helpers.removeCharacters(specifiedProductSteps.getProductPrice());
        productDefaultPrice2 = Double.parseDouble(productPriceFromProductPage2);
        specifiedProductSteps.clickReadMoreDescriptionButton();
        specifiedProductSteps.clickIncreaseProductQuantityBy1();
        specifiedProductSteps.clickAddToCartButton();
        popupProductSku2 = helpers.replaceNewLineFromStringWithSpace(specifiedProductSteps.getPopUpProductSku());
        popUpProductQuantity2 = specifiedProductSteps.getPopUpProductQuantity();
        popUpTotalPrice2 = helpers.removeCharacters(specifiedProductSteps.getPopUpTotalPrice());
        totalProductPrice2 = Double.parseDouble(popUpTotalPrice2);
        helpers.assertProductDetails(productSkuFromProductPage2,popupProductSku2,productQuanity2,popUpProductQuantity2,productDefaultPrice2,totalProductPrice2);
        specifiedProductSteps.createAProductDetailsList();
        specifiedProductSteps.clickGoToCheckoutButton();

    }


}
