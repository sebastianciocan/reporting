package com.drupal.steps.product;

import com.drupal.pages.product.AllProductsPage;
import com.drupal.steps.AbstractSteps;
import net.thucydides.core.annotations.Step;

/**
 * Created by sebastianciocan on 5/5/2017.
 */
public class AllProductsSteps extends AbstractSteps {

        AllProductsPage allProductsPage;

        @Step
        public void selectSpecifiedProduct(String productName){
                allProductsPage.selectSpecifiedProduct(productName);
        }
}
