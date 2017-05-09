package com.drupal.pages.product;

import com.drupal.pages.AbstractPage;
import tools.ProductObjectList;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sebastianciocan on 5/5/2017.
 */
public class SpecifiedProductPage extends AbstractPage {


    @FindBy(css = ".breadcrumb")
    private WebElement pathToTheProduct;

    @FindBy(css = ".field.field-name-title-field")
    private WebElement productName;

    @FindBy(css = ".commerce-product-sku")
    private WebElement productCode;

    @FindBy(css = ".field.field-name-field-brand .field-item.even")
    private WebElement productBrand;

    @FindBy(css = ".field.field-name-commerce-price .field-item.even")
    private WebElement productPrice;

    @FindBy(css = ".more-link")
    private WebElement readMoreDescriptionButton;

    @FindBy(css = ".ui-spinner-up.ui-spinner-button.ui-state-default.ui-corner-tr")
    private WebElement increaseProductQuantityBy1;

    @FindBy(css = "#edit-submit")
    private WebElement addToCartButton;

    @FindBy(css = ".entity .commerce-product-sku:not(.commerce-product-sku-label)")
    private WebElement popupProductSku;

    @FindBy(css = ".views-field.views-field-quantity.field span:last-child")
    private WebElement popupProductQuantity;

    @FindBy(css = ".views-field.views-field-commerce-total span:last-child")
    private WebElement popUpTotalPrice;

    @FindBy(css = ".button.checkout a")
    private WebElement goToCheckoutButton;

    @FindBy(css = ".continue")
    private WebElement continueShoppingButton;

    public void makeAProductDetailsList(){
        List<ProductObjectList> productDetails = new ArrayList<ProductObjectList>();
        productDetails.add(new ProductObjectList(productCode.getText(), productPrice.getText(), popupProductQuantity.getText()));
    }

    public void checkIfThePathToTheProductIsCorrect(String productName){
        String path = pathToTheProduct.getText();
        Assert.assertTrue("The path is not the good one!",path.contains(productName));
    }
    public String getProductName(){
        element(productName).waitUntilVisible();
        return productName.getText();
    }
    public String getProductCode(){
        element(productCode).waitUntilVisible();
        return productCode.getText();
    }
    public String getProductBrand(){
        element(productBrand).waitUntilVisible();
        return productBrand.getText();
    }
    public String getProductPrice(){
        element(productPrice).waitUntilVisible();
        return productPrice.getText();
    }
    public void clickReadMoreDescriptionButton(){
        try{
            readMoreDescriptionButton.click();
        }
        catch (Exception e){
            System.out.println("The read more button is not displayed!");
        }
    }
    public void clickIncreaseProductQuantityBy1(){
        element(increaseProductQuantityBy1).waitUntilVisible();
        increaseProductQuantityBy1.click();
    }
    public void clickAddToCartButton(){
        element(addToCartButton).waitUntilVisible();
        addToCartButton.click();
    }
    public String getPopUpProductSku(){
        element(popupProductSku).waitUntilVisible();
        return popupProductSku.getText();
    }
    public String getPopUpQuantity(){
        element(popupProductQuantity).waitUntilVisible();
        return popupProductQuantity.getText();
    }
    public String getPopUpTotalPrice(){
        element(popUpTotalPrice).waitUntilVisible();
        return popUpTotalPrice.getText();
    }
    public void clickGoToCheckoutButton(){
        element(goToCheckoutButton).waitUntilVisible();
        goToCheckoutButton.click();
    }
    public void clickContinueShoppingButton(){
        element(continueShoppingButton).waitUntilVisible();
        continueShoppingButton.click();
    }
}
