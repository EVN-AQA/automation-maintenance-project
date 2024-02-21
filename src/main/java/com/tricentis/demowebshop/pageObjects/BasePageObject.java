package com.tricentis.demowebshop.pageObjects;

import com.tricentis.demowebshop.core.BasePage;
import com.tricentis.demowebshop.core.GlobalConstants;
import com.tricentis.demowebshop.pageUIs.BasePageUI;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BasePageObject extends BasePage {

    private final WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

}
