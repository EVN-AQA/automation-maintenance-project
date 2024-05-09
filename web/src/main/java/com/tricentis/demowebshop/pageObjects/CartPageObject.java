package com.tricentis.demowebshop.pageObjects;
import com.tricentis.demowebshop.core.BasePage;
import com.tricentis.demowebshop.pageUIs.CartPageUI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CartPageObject extends BasePage {

    private final WebDriver driver;

    public CartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyProductIsInCart(String productTitle) {
        return isElementDisplayed(driver, CartPageUI.PRODUCT_IN_CART, productTitle);
    }

    public boolean verifyEmtptyCart() {
        return isElementDisplayed(driver, CartPageUI.EMPTY_CART);
    }
    public void clickOnUpdateShoppingCartBtn(){
        clickToElement(driver,CartPageUI.UPDATE_SHOPPING_CART_BTN);
    }
    public void removeAllFromCart(){
        List<WebElement> items = driver.findElements(By.xpath(CartPageUI.REMOVE_FROM_CART_CHECKBOX));
        if(items.size() > 0){
            for(int index = 0; index < items.size(); index++){
                 items.get(index).click();
            }
            clickToElement(driver,CartPageUI.UPDATE_SHOPPING_CART_BTN); 
        }
    }

    public String calculateTotalBeforeTax(){
        double total = 0.00;
        List<WebElement> items = driver.findElements(By.xpath(CartPageUI.SUB_TOTAL));
        if(items.size() > 0){
            for(int index = 0; index < items.size(); index++){
                String subtotal = items.get(index).getAttribute("value");
                total+= Double.parseDouble(subtotal);
            }
        }
        return total+"";
    }

    public String getProductPrice(String product){
        return getElementText(driver, CartPageUI.PRODUCT_PRICE, product);
    }
    public String getProductQuantity(String product){
        return getElementAttribute(driver, CartPageUI.PRODUCT_QUANTITY, "value",product);
    }
    public String getProductTotal(String product){
        return getElementText(driver, CartPageUI.SUB_TOTAL_BY_PRODUCT, product);
    }
    public String getTotalBeforeTax(){
        return getElementText(driver, CartPageUI.TOTAL_BEFORE_TAX);
    }
}
