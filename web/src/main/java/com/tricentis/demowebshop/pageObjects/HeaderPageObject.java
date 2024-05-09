package com.tricentis.demowebshop.pageObjects;
import java.time.Duration;
import com.tricentis.demowebshop.core.BasePage;
import com.tricentis.demowebshop.pageUIs.HeaderPageUI;
import org.openqa.selenium.WebDriver;

public class HeaderPageObject extends BasePage {

    private final WebDriver driver;

    public HeaderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHomeButton() {
        clickToElement(driver, HeaderPageUI.HOME_BTN_BY_CSS);
    }

    public void clickLoginHyperlink() {
        clickToElement(driver, HeaderPageUI.LOGIN_HLK_BY_CSS);
    }

    public void clickRegisterHyperlink() {
        clickToElement(driver, HeaderPageUI.REGISTER_HLK_BY_CSS);
    }

    public boolean isHomeButtonDisplayed() {
        return isElementDisplayed(driver, HeaderPageUI.HOME_BTN_BY_CSS);
    }
    public boolean isLogoutHyperlinkDisplayed() {
        return isElementDisplayed(driver, HeaderPageUI.LOGOUT_HLK_BY_CSS);
    }
    public String getUserEmail() {
        return getElementText(driver,HeaderPageUI.CUSTOMER_INFO_LINK_BY_XPATH);
    }

    public void goToSubProductPage(String productCategory, String productSubCategory) {
        waitForPageLoadedCompletely(driver,Duration.ofSeconds(4));
        hoverElement(driver, HeaderPageUI.PRODUCT_CATEGORY_XPATH,productCategory);
        clickToElement(driver, HeaderPageUI.PRODUCT_SUBCATEGORY_XPATH,productSubCategory);
    }
    public void goToProductCategoryPage(String productCategory) {
        hoverAndClickToElement(driver, HeaderPageUI.PRODUCT_CATEGORY_XPATH,productCategory);
    }
}
