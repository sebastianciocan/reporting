package com.drupal.pages.product;

import com.drupal.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.FindBy;

import java.util.List;

/**
 * Created by sebastianciocan on 5/5/2017.
 */
public class AllProductsPage extends AbstractPage {

    @FindBy(css = ".view-content .item-list>.all-products")
    private WebElement allProducts;

    public void selectSpecifiedProduct(String productName){
        element(allProducts).waitUntilVisible();
        List<WebElement> allProductsElements = getDriver().findElements(By.cssSelector("article"));

        for(WebElement product : allProductsElements){
            WebElement name = product.findElement(By.cssSelector("h2 a"));
            if(name.getText().contains(productName)){
                product.click();
                break;
            }
        }
    }

}
