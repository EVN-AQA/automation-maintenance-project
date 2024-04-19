package com.tricentis.demowebshop.pageUIs;

import org.openqa.selenium.By;

public class RegisterPageUI {
    public static final String GENDER_RADIO_BTN = "//input[@id='gender-%s']";
    public static final By COMPLETE_REGISTRATION_BY_XPATH = By.xpath("//div[@class='result' and contains(text(),'Your registration completed')]");
    public static final By PASSWORD_NOT_MATCH_BY_XPATH = By.xpath("//span[@for='ConfirmPassword']");
}
