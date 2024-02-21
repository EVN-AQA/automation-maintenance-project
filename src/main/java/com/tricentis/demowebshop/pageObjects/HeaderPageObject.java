package com.tricentis.demowebshop.pageObjects;

import com.tricentis.demowebshop.core.BasePage;
import com.tricentis.demowebshop.core.GlobalConstants;
import com.tricentis.demowebshop.pageUIs.BasePageUI;
import com.tricentis.demowebshop.pageUIs.HeaderPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.List;
import java.util.stream.Collectors;

public class HeaderPageObject extends BasePage {

    private final WebDriver driver;

    public HeaderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHomeButton() {
        clickToElement(driver, HeaderPageUI.HOME_BTN_BY_CSS);
    }

    public boolean isHomeButtonDisplayed() {
        return isElementDisplayed(driver, HeaderPageUI.HOME_BTN_BY_CSS);
    }
    
}
