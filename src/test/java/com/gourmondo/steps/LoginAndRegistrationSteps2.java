package com.gourmondo.steps;

import com.gourmondo.pages.LoginAndRegistrationPage2;
import net.thucydides.core.annotations.Step;
import tools.CustomerAccountModel;
import tools.EmailModel;

/**
 * Created by sebastianciocan on 5/11/2017.
 */
public class LoginAndRegistrationSteps2 extends AbstractSteps {

    LoginAndRegistrationPage2 loginAndRegistrationPage2;


    @Step
    public void clickSwitchToRegistrationFormButton(){
        loginAndRegistrationPage2.clickSwitchToRegistrationButton();
    }
    @Step
    public void setFirstNameInput(String firstName){
        loginAndRegistrationPage2.setFirstNameInput(firstName);
    }
    @Step
    public void setLastNameInput(String lastName){
        loginAndRegistrationPage2.setLastNameInput(lastName);
    }
    @Step
    public void setEmailInput(String email){
        loginAndRegistrationPage2.setEmailInput(email);
    }
    @Step
    public void setDayDropDown(String day){
        loginAndRegistrationPage2.setDayDropDown(day);
    }
    @Step
    public void setMonthDropDown(String month){
        loginAndRegistrationPage2.setMonthDropDown(month);
    }
    @Step
    public void setYearDropDown(String year){
        loginAndRegistrationPage2.setYearDropDown(year);
    }
    @Step
    public void setPasswordInput(String password){
        loginAndRegistrationPage2.setPasswordInput(password);
    }
    @Step
    public void setConfirmPasswordInput(String confirmPassword){
        loginAndRegistrationPage2.setConfirmPasswordInput(confirmPassword);
    }
    @Step
    public void clickCheckboxForPa(){
        loginAndRegistrationPage2.clickCheckboxForPa();
    }
    @Step
    public void clickConfirmRegistrationButton(){
        loginAndRegistrationPage2.clickConfirmRegistrationButton();
    }
    @Step
    public void assertTheAccountWasCreated(String message){
        loginAndRegistrationPage2.assertTheAccountWasCreated(message);
    }
    @Step
    public void validateEmailData(EmailModel emailModel, CustomerAccountModel customerAccountModel){
        loginAndRegistrationPage2.validateEmailData(emailModel,customerAccountModel);
    }

}
