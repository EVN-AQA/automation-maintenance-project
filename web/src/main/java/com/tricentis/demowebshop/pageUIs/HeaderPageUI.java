package com.tricentis.demowebshop.pageUIs;

import org.openqa.selenium.By;

public class HeaderPageUI {
    public static final By HOME_BTN_BY_CSS = By.cssSelector("div.header-logo > a");
    public static final By REGISTER_HLK_BY_CSS = By.cssSelector("div.header-links a.ico-register");
    public static final By LOGIN_HLK_BY_CSS = By.cssSelector("div.header-links a.ico-login");
    public static final By CART_HLK_BY_CSS = By.cssSelector("div.header-links a.ico-cart");
    public static final By WISHLIST_HLK_BY_CSS = By.cssSelector("div.header-links a.ico-wishlist");
    public static final By LOGOUT_HLK_BY_CSS = By.cssSelector("div.header-links a.ico-logout");
    public static final By CUSTOMER_INFO_LINK_BY_XPATH = By.xpath("//div[@class='header-links']//a[@href='/customer/info']");
    public static final String PRODUCT_CATEGORY_XPATH = "//ul[@class='top-menu']//a[contains(text(),'%s')]";
    public static final String PRODUCT_SUBCATEGORY_XPATH = "//ul[@class='top-menu']//ul//a[contains(text(),'%s')]";
}
