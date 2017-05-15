package com.gourmondo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

/**
 * Created by sebastianciocan on 5/11/2017.
 */
public class HeaderPage2 extends AbstractPage {

    @FindBy(css = "#log-in")
    private WebElement loginAndRegisterButton;

    public void clickLoginAndRegisterButton(){
        element(loginAndRegisterButton).waitUntilVisible();
        loginAndRegisterButton.click();
    }

}
