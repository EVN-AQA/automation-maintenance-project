package com.tricentis.demowebshop.pageObjects;
import com.tricentis.demowebshop.core.BasePage;
import com.tricentis.demowebshop.pageUIs.ProductPageUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPageObject extends BasePage {

    private final WebDriver driver;

    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCartButton(String productTitle) {
        clickToElement(driver, ProductPageUI.ADD_TO_CART_BTN_BY_PRODUCT_NAME_XPATH,productTitle);
    }
    public boolean verifySuccessNotiBar(){
        return isElementDisplayed(driver, ProductPageUI.BAR_NOTI_SUCCESS_XPATH);
        
    }
    public void clickOnShoppingCartLinkInNotiBar(){
        clickToElementByJS(driver,ProductPageUI.SHOPPING_CART_LINK_IN_NOTI_XPATH);
    }
    public void goToProduct(String productTitle){
        clickToElement(driver, ProductPageUI.PRODUCT_TITLE_XPATH,productTitle);
    }
    public void clickAddToCartBtnInProductPage() {
        clickToElement(driver, ProductPageUI.ADD_TO_CART_BTN_XPATH);
    }
    public void chooseDropdownList(String dropdownName,String option) {
        selectItemInDropdownByVisibleText(driver,ProductPageUI.DROPDOWN_LIST_XPATH, option, dropdownName);
    }
}
