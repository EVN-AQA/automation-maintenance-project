package com.tricentis.demowebshop.stepDefinitions;
import com.tricentis.demowebshop.utilities.RandomUtil;
import com.tricentis.demowebshop.core.hook.Hook;
import com.tricentis.demowebshop.pageObjects.RegisterPageObject;
import com.tricentis.demowebshop.pageObjects.HeaderPageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {

    private final WebDriver driver;
    private final RegisterPageObject RegisterPageObject;
    private final HeaderPageObject headerPageObject;
    String email;

    public RegisterPageSteps() {
        driver = Hook.driver;
        RegisterPageObject = new RegisterPageObject(driver);
        headerPageObject = new HeaderPageObject(driver);
    }
  
    @Then("I verify the register form of register page is displayed")
    public void iVerifyTheHomeButtonIsDisplayed() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(RegisterPageObject.isRegisterFormLabelDisplayed("Gender")).isTrue();
        softAssertions.assertThat(RegisterPageObject.isGenderMaleRadionBtnDisplayed()).isTrue();
        softAssertions.assertThat(RegisterPageObject.isGenderFemaleRadionBtnDisplayed()).isTrue();
        
        softAssertions.assertThat(RegisterPageObject.isRegisterFormLabelDisplayed("First name")).isTrue();
        softAssertions.assertThat(RegisterPageObject.isFirstNameTextBoxDisplayed()).isTrue();

        softAssertions.assertThat(RegisterPageObject.isRegisterFormLabelDisplayed("Last name")).isTrue();
        softAssertions.assertThat(RegisterPageObject.isLastNameTextBoxDisplayed()).isTrue();

        softAssertions.assertThat(RegisterPageObject.isRegisterFormLabelDisplayed("Email")).isTrue();
        softAssertions.assertThat(RegisterPageObject.isEmailTextBoxDisplayed()).isTrue();

        softAssertions.assertThat(RegisterPageObject.isRegisterFormLabelDisplayed("Password")).isTrue();
        softAssertions.assertThat(RegisterPageObject.isPasswordTextBoxDisplayed()).isTrue();

        softAssertions.assertThat(RegisterPageObject.isRegisterFormLabelDisplayed("Confirm password")).isTrue();
        softAssertions.assertThat(RegisterPageObject.isConfirmPasswordTextBoxDisplayed()).isTrue();

        softAssertions.assertThat(RegisterPageObject.isRegisterBtnDisplayed()).isTrue();
        softAssertions.assertAll();
    }

    @When("I input valid values in the register form")
    public void iInputValidValuesInRegisterForm() {
       String randomPassword = "password" +RandomUtil.getRandomNumberInBorder(99999);
        email = "testEmail-"+RandomUtil.getRandomString(10)+"@gmail.com";
            RegisterPageObject.chooseGender("male");
         RegisterPageObject.inputToRegisterFormTextBox("FirstName","FirstName-"+RandomUtil.getRandomString(10));
         RegisterPageObject.inputToRegisterFormTextBox("LastName","LastName-"+RandomUtil.getRandomString(10));
         RegisterPageObject.inputToRegisterFormTextBox("Email", email);
         RegisterPageObject.inputToRegisterFormTextBox("Password",randomPassword);
         RegisterPageObject.inputToRegisterFormTextBox("ConfirmPassword",randomPassword);
    }

    @When("I input values with not match passwords in the register form")
    public void iInputValuesPasswordsNotMatchInRegisterForm() {
       String randomPassword = "password" +RandomUtil.getRandomNumberInBorder(99999);
        email = "testEmail-"+RandomUtil.getRandomString(10)+"@gmail.com";
            RegisterPageObject.chooseGender("male");
         RegisterPageObject.inputToRegisterFormTextBox("FirstName","FirstName-"+RandomUtil.getRandomString(10));
         RegisterPageObject.inputToRegisterFormTextBox("LastName","LastName-"+RandomUtil.getRandomString(10));
         RegisterPageObject.inputToRegisterFormTextBox("Email", email);
         RegisterPageObject.inputToRegisterFormTextBox("Password",randomPassword);
         RegisterPageObject.inputToRegisterFormTextBox("ConfirmPassword",randomPassword+"*");
    }

    @When("I click on Register button")
    public void iClickRegisterButton() {
        RegisterPageObject.clickRegisterButton();
    }

    @Then("I verify registration successful")
    public void iVerifyRegistrationCompleted() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(RegisterPageObject.isCompletedRegistrationTextDisplayed()).isTrue();
        softAssertions.assertThat(headerPageObject.getUserEmail()).isEqualTo(email);
    }

    @Then("I verify the error message {string} when passwords not match")
    public void iVerifyErrorMessageLoginIsDisplayed(String messageExpected) {
        Assert.assertEquals(RegisterPageObject.getPasswordNotMatchErrorMsg(), messageExpected);
    }
}
