package com.tricentis.demowebshop.stepDefinitions;

import com.github.dockerjava.core.dockerfile.DockerfileStatement.Add;
import com.tricentis.demowebshop.core.hook.Hook;
import com.tricentis.demowebshop.pageObjects.ProductPageObject;
import com.tricentis.demowebshop.pageObjects.BasePageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class ProductPageSteps {

    private final WebDriver driver;
    private final ProductPageObject productPageObject;
    private final BasePageObject basePageObject;

    public ProductPageSteps() {
        driver = Hook.driver;
        productPageObject = new ProductPageObject(driver);
        basePageObject = new BasePageObject(driver);
    }

    @When("I add product {string} to cart")
    public void iAddProductToCart(String productTitle) {
        productPageObject.clickAddToCartButton(productTitle);
        basePageObject.waitForPageToLoad();
    }
    @Then("I should see success notification bar displayed")
    public void iVerifySuccessNotiBar() {
        productPageObject.verifySuccessNotiBar();
    }

    @When("I navigate to shopping cart from link in the notification bar")
    public void iGoToCartFromNotiBar() {
        productPageObject.clickOnShoppingCartLinkInNotiBar();
    }
  
    @When("I open product details page {string}")
    public void iGoToProduct(String productTitle) {
        productPageObject.goToProduct(productTitle);
    }
    @When("I click on Add to cart button in product details page")
    public void iAddProductToCartInProductPage() {
        productPageObject.clickAddToCartBtnInProductPage();
    }
    @When("I choose option {string} in dropdown list {string}")
    public void iChooseDropdownList(String option, String dropdownName) {
        productPageObject.chooseDropdownList(dropdownName,option);
    }
}
