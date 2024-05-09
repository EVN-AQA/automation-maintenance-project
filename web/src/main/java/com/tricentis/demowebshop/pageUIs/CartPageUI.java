package com.tricentis.demowebshop.pageUIs;

import org.openqa.selenium.By;

public class CartPageUI {
    public static final String ADD_TO_CART_BTN_BY_PRODUCT_NAME_XPATH ="//a[text()='%s']//parent::h2//following-sibling::div[@class='add-info']/div/input[@value='Add to cart']";
    public static final String PRODUCT_IN_CART = "//td[@class='product']/a[text()='%s']";
    public static final String PRODUCT_PRICE = PRODUCT_IN_CART+ "//ancestor::tr//span[@class='product-unit-price']";
    public static final String PRODUCT_QUANTITY = PRODUCT_IN_CART+ "//ancestor::tr//input[@class='qty-input']";
    public static final String SUB_TOTAL_BY_PRODUCT = PRODUCT_IN_CART+ "//ancestor::tr//span[@class='product-subtotal']";
    public static final String SUB_TOTAL = "//span[@class='product-subtotal']";
    public static final String REMOVE_FROM_CART_CHECKBOX = "//input[@name='removefromcart']";
    public static final By UPDATE_SHOPPING_CART_BTN = By.xpath("//input[@name='updatecart']");
    public static final By EMPTY_CART = By.xpath("//div[contains(text(),'Your Shopping Cart is empty!')]");
    public static final By TOTAL_BEFORE_TAX = By.xpath("(//table[@class='cart-total']//span[@class='product-price'])[1]");
}

