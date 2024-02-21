package com.tricentis.demowebshop.stepDefinitions;

import com.tricentis.demowebshop.core.hook.Hook;
import com.tricentis.demowebshop.pageObjects.HeaderPageObject;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HeaderPageSteps {

    private final WebDriver driver;
    private final HeaderPageObject headerPageObject;

    public HeaderPageSteps() {
        driver = Hook.driver;
        headerPageObject = new HeaderPageObject(driver);
    }

    @Then("I verify the home button is displayed")
    public void iVerifyTheHomeButtonIsDisplayed() {
        Assert.assertTrue(headerPageObject.isHomeButtonDisplayed());
    }
}
