package com.tricentis.demowebshop.pageObjects;

import com.tricentis.demowebshop.core.BasePage;
import com.tricentis.demowebshop.pageUIs.RegisterPageUI;
import com.tricentis.demowebshop.pageUIs.BasePageUI;
import org.openqa.selenium.WebDriver;

// import java.time.Duration;

public class RegisterPageObject extends BasePage {

    private final WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }
  
    public void clickRegisterButton() {
        clickToElement(driver, BasePageUI.BTN_XPATH, "Register");
    }

    
    public void VerifyRegisterSuccessfully() {
        clickToElement(driver, BasePageUI.BTN_XPATH, "Register");
    }

    public void chooseGender( String gender) {
        checkCheckbox(driver, RegisterPageUI.GENDER_RADIO_BTN, gender, gender);
    }

    public boolean isRegisterFormLabelDisplayed(String labelName) {
        return isElementDisplayed(driver, BasePageUI.LABEL_XPATH, labelName);
    }

    public void inputToRegisterFormTextBox(String textboxId, String textBoxValue) {
        sendKeysToElement(driver, BasePageUI.TXTBOX_XPATH, textBoxValue, textboxId);
    }
    public boolean isGenderMaleRadionBtnDisplayed() {
        return isElementDisplayed(driver, RegisterPageUI.GENDER_RADIO_BTN, "male");
    }
    
    public boolean isGenderFemaleRadionBtnDisplayed() {
        return isElementDisplayed(driver, RegisterPageUI.GENDER_RADIO_BTN, "female");
    }

    public boolean isFirstNameTextBoxDisplayed() {
        return isElementDisplayed(driver, BasePageUI.TXTBOX_XPATH, "FirstName");
    }

    public boolean isLastNameTextBoxDisplayed() {
        return isElementDisplayed(driver, BasePageUI.TXTBOX_XPATH, "LastName");
    }

    public boolean isEmailTextBoxDisplayed() {
        return isElementDisplayed(driver, BasePageUI.TXTBOX_XPATH, "Email");
    }

    public boolean isPasswordTextBoxDisplayed() {
        return isElementDisplayed(driver, BasePageUI.TXTBOX_XPATH, "Password");
    }

    public boolean isConfirmPasswordTextBoxDisplayed() {
        return isElementDisplayed(driver, BasePageUI.TXTBOX_XPATH, "ConfirmPassword");
    }

    public boolean isRegisterBtnDisplayed() {
        return isElementDisplayed(driver, BasePageUI.BTN_XPATH, "Register");
    }

    public boolean isCompletedRegistrationTextDisplayed() {
        return isElementDisplayed(driver, RegisterPageUI.COMPLETE_REGISTRATION_BY_XPATH);
    }

    public String getPasswordNotMatchErrorMsg() {
        return getElementText(driver,RegisterPageUI.PASSWORD_NOT_MATCH_BY_XPATH);
    }
}
