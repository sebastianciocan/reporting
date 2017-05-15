package com.drupal.tests.product;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        US002AddTwoProductsToCartTest.class,
        US003AddProductsToCartUsingCsvFileTest.class
})
public class ProductTestSuites {
}
