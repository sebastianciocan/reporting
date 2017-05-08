package com.drupal.pages.header;

import org.openqa.selenium.WebElement;

import com.drupal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.FindBy;

import net.serenitybdd.core.annotations.findby.FindBy;

public class MenuNavigationPage extends AbstractPage{



    @FindBy(css = "#main-menu")
    private WebElement mainMenuItems;

    @FindBy(css = ".menu-633.first>a")
    WebElement toCarryMenuItem;


    @FindBy(css = ".menu-634>a")
    WebElement toDrinkWithItem;


    public void selectACategoryFromMainMenu(){
        clickAMenuItemFromList(mainMenuItems,"All Products");
    }

}
