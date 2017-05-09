package com.drupal.steps.product;

import com.drupal.pages.product.SpecifiedProductPage;
import com.drupal.steps.AbstractSteps;
import net.thucydides.core.annotations.Step;

/**
 * Created by sebastianciocan on 5/5/2017.
 */
public class SpecifiedProductSteps extends AbstractSteps {
    SpecifiedProductPage commerceGuyLaptopBagSteps;

    @Step
    public void createAProductDetailsList(){
        commerceGuyLaptopBagSteps.makeAProductDetailsList();
    }

    @Step
    public void checkIfThePathToTheProductIsCorrect(String productName){
        commerceGuyLaptopBagSteps.checkIfThePathToTheProductIsCorrect(productName);
    }
    @Step
    public String getProductName(){
        return commerceGuyLaptopBagSteps.getProductName();
    }
    @Step
    public String getProductCode(){
        return commerceGuyLaptopBagSteps.getProductCode();
    }
    @Step
    public String getProductBrand(){
        return commerceGuyLaptopBagSteps.getProductBrand();
    }
    @Step
    public String getProductPrice(){
        return commerceGuyLaptopBagSteps.getProductPrice();
    }
    @Step
    public void clickReadMoreDescriptionButton(){
        commerceGuyLaptopBagSteps.clickReadMoreDescriptionButton();
    }
    @Step
    public void clickIncreaseProductQuantityBy1(){
        commerceGuyLaptopBagSteps.clickIncreaseProductQuantityBy1();
    }
    @Step
    public void clickAddToCartButton(){
        commerceGuyLaptopBagSteps.clickAddToCartButton();
    }
    @Step
    public String getPopUpProductSku(){
        return commerceGuyLaptopBagSteps.getPopUpProductSku();
    }
    @Step
    public String getPopUpProductQuantity(){
        return commerceGuyLaptopBagSteps.getPopUpQuantity();
    }
    @Step
    public String getPopUpTotalPrice(){
        return commerceGuyLaptopBagSteps.getPopUpTotalPrice();
    }
    @Step
    public void clickGoToCheckoutButton(){
        commerceGuyLaptopBagSteps.clickGoToCheckoutButton();
    }
    @Step
    public void clickContinueShoppingButton(){
        commerceGuyLaptopBagSteps.clickContinueShoppingButton();
    }
}
