package com.tricentis.demowebshop.pageObjects;
import com.tricentis.demowebshop.pageUIs.BasePageUI;
import com.tricentis.demowebshop.core.BasePage;
import org.openqa.selenium.WebDriver;
import com.tricentis.demowebshop.core.GlobalConstants;

public class BasePageObject extends BasePage {

    private final WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForPageToLoad() {
        waitForElementUntilInvisible(driver, BasePageUI.LOADING_IMAGE,GlobalConstants.TIME_OUT_LOADING);
    }
}
