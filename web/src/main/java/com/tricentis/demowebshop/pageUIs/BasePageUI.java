package com.tricentis.demowebshop.pageUIs;

import org.openqa.selenium.By;

public class BasePageUI {
    public static final By EVENT_GLOBAL_LOADER = By.cssSelector(".evnt-global-loader");

    public static final String LINK_XPATH = "//a[normalize-space(text())='%s']";
    public static final String BTN_XPATH = "//input[@value='%s']";
    public static final String TXTBOX_XPATH = "//input[@id='%s']";
    public static final String LABEL_XPATH ="//label[contains(text(),'%s')]";
}

