package com.drupal.tests.product;

import com.drupal.pages.cart.ShoppingCartPage;
import com.drupal.steps.navigation.NavigationSteps;
import com.drupal.steps.product.AllProductsSteps;
import com.drupal.steps.product.SpecifiedProductSteps;
import com.drupal.tests.BaseTest;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import tools.Constants;
import tools.Helpers;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom( value = Constants.CSV_FILES_PATH + "ProductNames.csv")
public class US003AddProductsToCartUsingCsvFileTest extends BaseTest {

    String productname;
    String productquantity;

    @Before
    public void setup(){
        webdriver.manage().window().maximize();

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
    public void testAddOneProductToCartUsingCsvFile(){

        Helpers helpers = new Helpers();
        navigationSteps.navigateTo(Constants.HOST);
        navigationSteps.selectProductCategoryFromMenuList(Constants.ALLPRODUCTSMENUITEM);
        allProductsSteps.selectSpecifiedProduct(productname);
        specifiedProductSteps.checkIfThePathToTheProductIsCorrect(productname);
        String productSkuFromProductPage2 = specifiedProductSteps.getProductCode();
        String productPriceFromProductPage2 = helpers.removeCharacters(specifiedProductSteps.getProductPrice());
        double productDefaultPrice2 = Double.parseDouble(productPriceFromProductPage2);
        specifiedProductSteps.clickReadMoreDescriptionButton();
        specifiedProductSteps.enterAProductQuantity(productquantity);
        specifiedProductSteps.clickAddToCartButton();
        String popupProductSku2 = helpers.replaceNewLineFromStringWithSpace(specifiedProductSteps.getPopUpProductSku());
        String popUpProductQuantity2 = helpers.removeCharacters(specifiedProductSteps.getPopUpProductQuantity());
        String popUpTotalPrice2 = helpers.removeCharacters(specifiedProductSteps.getPopUpTotalPrice());
        double totalProductPrice2 = Double.parseDouble(popUpTotalPrice2);
        System.out.println(productquantity);
        System.out.println(popUpProductQuantity2);
        helpers.assertProductDetails(productSkuFromProductPage2,popupProductSku2,productquantity,popUpProductQuantity2,productDefaultPrice2,totalProductPrice2);
        specifiedProductSteps.createAProductDetailsList();
        specifiedProductSteps.clickGoToCheckoutButton();
    }
}
