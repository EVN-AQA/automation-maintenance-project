package com.tricentis.demowebshop.pageUIs;

import org.openqa.selenium.By;

public class ProductPageUI {
    public static final String ADD_TO_CART_BTN_BY_PRODUCT_NAME_XPATH ="//a[text()='%s']//parent::h2//following-sibling::div[@class='add-info']/div/input[@value='Add to cart']";
    public static final By BAR_NOTI_SUCCESS_XPATH = By.xpath("//div[@id='bar-notification']/p[contains(text(),'The product has been added')]");
    public static final By SHOPPING_CART_LINK_IN_NOTI_XPATH = By.xpath("//div[@id='bar-notification']//a[@href='/cart']");
    public static final String PRODUCT_TITLE_XPATH = "//a[text()='%s']";
    public static final By ADD_TO_CART_BTN_XPATH = By.xpath("//div[@class='overview']//input[@value='Add to cart']");
    public static final String DROPDOWN_LIST_XPATH = "//label[contains(text(),'%s')]//ancestor::dl//dd/select";
}

