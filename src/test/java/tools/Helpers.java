package tools;

import org.junit.Assert;

/**
 * Created by sebastianciocan on 5/8/2017.
 */
public class Helpers {

    public static double multiplyTwoNumbers(double first, double second){
        return (first * second);
    }

    public static String removeCharacters(String input){
        return input.replaceAll("[^0-9\\.]","");
    }
    public static String replaceNewLineFromStringWithSpace(String input){
        return input.replaceAll("\n"," ");
    }
    public void assertProductDetails(String productSku, String popupSku, String productQuantity, String popupQuantity, double productDefaultPrice, double totalPrice){
        Assert.assertTrue("The product's SKU do not match!",productSku.contentEquals(popupSku));

        Assert.assertTrue("The quantity does not match!",productQuantity.contentEquals(popupQuantity));

        Assert.assertTrue("The total price does not match the products price x quantity!",multiplyTwoNumbers(productDefaultPrice,Double.valueOf(productQuantity)) == totalPrice);
    }
}
