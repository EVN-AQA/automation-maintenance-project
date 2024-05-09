package com.tricentis.demowebshop.stepDefinitions;

import com.tricentis.demowebshop.core.hook.Hook;
import com.tricentis.demowebshop.pageObjects.CartPageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class CartPageSteps {

    private final WebDriver driver;
    private final CartPageObject cartPageObject;

    public CartPageSteps() {
        driver = Hook.driver;
        cartPageObject = new CartPageObject(driver);
    }

    @Then("I should see the added product {string} in the shopping cart")
    public void iSeeAddedProductInCart(String productTitle) {
        Assert.assertTrue(cartPageObject.verifyProductIsInCart(productTitle));
    }

    @Then("I remove all items in the shopping cart")
    public void iRemoveAllItemsInCart() {
      cartPageObject.removeAllFromCart();
    }

    @Then("I should see text informing the shopping cart is empty")
    public void iverifyEmptyCart() {
        Assert.assertTrue(cartPageObject.verifyEmtptyCart());
    }

    @Then("I should see the price {string}, quantity {string}, total {string} of product {string} displayed correctly")
    public void iverifyProductAttributesInCart( String price, String quantity, String total,String product) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(cartPageObject.getProductPrice(product)).isEqualTo(price);
        softAssertions.assertThat(cartPageObject.getProductQuantity(product)).isEqualTo(quantity);
        softAssertions.assertThat(cartPageObject.getProductTotal(product)).isEqualTo(total);
    }

    @Then("I should see the subtotal before tax of products displayed correctly")
    public void iverifyTotalInCart() {
        Assert.assertEquals(cartPageObject.getTotalBeforeTax(), cartPageObject.calculateTotalBeforeTax());
    }
}
