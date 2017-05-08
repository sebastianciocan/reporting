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
    public String productName = "";

    @Before
    public void setup(){
        url = "http://172.22.120.86:8080/";
        productName = "Drupal Commerce Ready for the Court";
        webdriver.manage().window().maximize();
    }

    @Steps
    public AllProductsSteps allProductsSteps;
    @Steps
    public NavigationSteps navigationSteps;
    @Steps
    public CommerceGuyLaptopBagSteps commerceGuyLaptopBagSteps;


    @Test
    public void addProductToCartFromProductPage(){
        Helpers helpers = new Helpers();
        navigationSteps.navigateTo(url);
        navigationSteps.selectProductCategoryFromMenuList();
        allProductsSteps.selectSpecifiedProduct(productName);
        commerceGuyLaptopBagSteps.checkIfThePathToTheProductIsCorrect(productName);
        String productSkuFromProductPage = commerceGuyLaptopBagSteps.getProductCode();
        String productPriceFromProductPage = commerceGuyLaptopBagSteps.getProductPrice().replaceAll("[^0-9\\.]","");
        double productDefaultPrice = Double.parseDouble(productPriceFromProductPage);
        commerceGuyLaptopBagSteps.clickReadMoreDescriptionButton();
        commerceGuyLaptopBagSteps.clickIncreaseProductQuantityBy1();
        commerceGuyLaptopBagSteps.clickAddToCartButton();
        String popupProductSku = commerceGuyLaptopBagSteps.getPopUpProductSku().replaceAll("\n"," ");
        Assert.assertTrue("The product's SKU do not match!",productSkuFromProductPage.contentEquals(popupProductSku));
        String popUpProductQuantity = commerceGuyLaptopBagSteps.getPopUpProductQuantity();
        Assert.assertTrue("The quantity does not match!",popUpProductQuantity.contentEquals("2"));
        String popUpTotalPrice = commerceGuyLaptopBagSteps.getPopUpTotalPrice().replaceAll("[^0-9\\.]","");
        double totalProductPrice = Double.parseDouble(popUpTotalPrice);
        Assert.assertTrue("The total price does not match the products price x quantity!", helpers.multiplyTwoNumbers(productDefaultPrice,2) == totalProductPrice);
        commerceGuyLaptopBagSteps.createAProductDetailsList();
        commerceGuyLaptopBagSteps.clickGoToCheckoutButton();

    }

}
