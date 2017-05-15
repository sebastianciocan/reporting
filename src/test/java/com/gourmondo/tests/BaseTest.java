package com.gourmondo.tests;

import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

/**
 * Created by sebastianciocan on 5/11/2017.
 */
public class BaseTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;



}
