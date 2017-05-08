package com.drupal.tests;

import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.Managed;

public class BaseTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;
    
    
}
