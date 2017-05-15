package com.gourmondo.steps;

import com.gourmondo.pages.HeaderPage2;
import net.thucydides.core.annotations.Step;

/**
 * Created by sebastianciocan on 5/11/2017.
 */
public class HeaderSteps2 extends AbstractSteps {
    HeaderPage2 headerPage2;

    @Step
    public void clickLoginAndRegisterButton(){
        headerPage2.clickLoginAndRegisterButton();
    }

}
