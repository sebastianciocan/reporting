package com.drupal.tests.product;

import com.drupal.Tools.Helpers;
import com.drupal.pages.AbstractPage;
import com.drupal.pages.product.AllProductsPage;
import com.drupal.steps.navigation.NavigationSteps;
import com.drupal.steps.product.AllProductsSteps;
import com.drupal.steps.product.CommerceGuyLaptopBagSteps;
import com.drupal.tests.BaseTest;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)
public class US002AddProductToCartTest extends BaseTest {

    public String url="";
    public String productName1 = "";
    public String productName2 = "";

    @Before
    public void setup(){
        url = "http://172.22.120.86:8080/";
        productName1 = "Drupal Commerce Ready for the Court";
        productName2 = "\"The Guy\" Mug";
        webdriver.manage().window().maximize();
    }

    @Steps
    public AllProductsSteps allProductsSteps;
    @Steps
    public NavigationSteps navigationSteps;
    @Steps
    public CommerceGuyLaptopBagSteps commerceGuyLaptopBagSteps;


    @Test
    public void addTwoProductsToCartFromProductPage(){
        Helpers helpers = new Helpers();
        navigationSteps.navigateTo(url);
        navigationSteps.selectProductCategoryFromMenuList();
        allProductsSteps.selectSpecifiedProduct(productName1);
        commerceGuyLaptopBagSteps.checkIfThePathToTheProductIsCorrect(productName1);
        String productSkuFromProductPage1 = commerceGuyLaptopBagSteps.getProductCode();
        String productPriceFromProductPage1 = commerceGuyLaptopBagSteps.getProductPrice().replaceAll("[^0-9\\.]","");
        double productDefaultPrice1 = Double.parseDouble(productPriceFromProductPage1);
        commerceGuyLaptopBagSteps.clickReadMoreDescriptionButton();
        commerceGuyLaptopBagSteps.clickIncreaseProductQuantityBy1();
        commerceGuyLaptopBagSteps.clickAddToCartButton();
        String popupProductSku1 = commerceGuyLaptopBagSteps.getPopUpProductSku().replaceAll("\n"," ");
        Assert.assertTrue("The product's SKU do not match!",productSkuFromProductPage1.contentEquals(popupProductSku1));
        String popUpProductQuantity1 = commerceGuyLaptopBagSteps.getPopUpProductQuantity();
        Assert.assertTrue("The quantity does not match!",popUpProductQuantity1.contentEquals("2"));
        String popUpTotalPrice1 = commerceGuyLaptopBagSteps.getPopUpTotalPrice().replaceAll("[^0-9\\.]","");
        double totalProductPrice1 = Double.parseDouble(popUpTotalPrice1);
        Assert.assertTrue("The total price does not match the products price x quantity!", helpers.multiplyTwoNumbers(productDefaultPrice1,2) == totalProductPrice1);
        commerceGuyLaptopBagSteps.createAProductDetailsList();
        commerceGuyLaptopBagSteps.clickContinueShoppingButton();
        navigationSteps.selectProductCategoryFromMenuList();
        allProductsSteps.selectSpecifiedProduct(productName2);
        commerceGuyLaptopBagSteps.checkIfThePathToTheProductIsCorrect(productName2);
        String productSkuFromProductPage2 = commerceGuyLaptopBagSteps.getProductCode();
        String productPriceFromProductPage2 = commerceGuyLaptopBagSteps.getProductPrice().replaceAll("[^0-9\\.]","");
        double productDefaultPrice2 = Double.parseDouble(productPriceFromProductPage2);
        commerceGuyLaptopBagSteps.clickReadMoreDescriptionButton();
        commerceGuyLaptopBagSteps.clickIncreaseProductQuantityBy1();
        commerceGuyLaptopBagSteps.clickAddToCartButton();
        String popupProductSku2 = commerceGuyLaptopBagSteps.getPopUpProductSku().replaceAll("\n"," ");
        Assert.assertTrue("The product's SKU do not match!",productSkuFromProductPage2.contentEquals(popupProductSku2));
        String popUpProductQuantity2 = commerceGuyLaptopBagSteps.getPopUpProductQuantity();
        Assert.assertTrue("The quantity does not match!",popUpProductQuantity2.contentEquals("2"));
        String popUpTotalPrice2 = commerceGuyLaptopBagSteps.getPopUpTotalPrice().replaceAll("[^0-9\\.]","");
        double totalProductPrice2 = Double.parseDouble(popUpTotalPrice2);
        Assert.assertTrue("The total price does not match the products price x quantity!", helpers.multiplyTwoNumbers(productDefaultPrice2,2) == totalProductPrice2);
        commerceGuyLaptopBagSteps.createAProductDetailsList();
        commerceGuyLaptopBagSteps.clickGoToCheckoutButton();

    }

}
