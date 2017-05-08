package com.drupal.Tools;

import com.drupal.pages.product.CommerceGuysLaptopBagPage;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sebastianciocan on 5/8/2017.
 */
public class ProductObjectList {

    WebElement productSku;
    WebElement productQuantity;
    WebElement productPrice;


    public ProductObjectList(WebElement productSku, WebElement productPrice, WebElement productQuantity){
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productSku = productSku;




    }

}
