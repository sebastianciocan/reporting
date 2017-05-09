package tools;

/**
 * Created by sebastianciocan on 5/8/2017.
 */
public class ProductObjectList {

    String productSku;
    String productQuantity;
    String productPrice;


    public ProductObjectList(String productSku, String productPrice, String productQuantity){
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productSku = productSku;

    }
    public String toString(){
        return "Product " + productSku + ", Product Price: " + productPrice + ", Product Quantity: " + productQuantity;
    }


}
