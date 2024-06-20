package com.epam.qavn.api.stepDefinitions;

import com.epam.qavn.api.core.GlobalConstant;
import com.epam.qavn.api.models.user.TokenResponse;
import com.epam.qavn.api.models.user.UserCredentialRequest;
import com.epam.qavn.api.services.UserService;
import com.epam.qavn.api.utils.enums.TokenResult;
import com.epam.qavn.api.utils.enums.TokenStatus;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.commons.httpclient.HttpStatus;
import org.junit.Assert;

import java.time.LocalDate;

public class GenerateToken {

    private Response tokenResponse;
    private UserCredentialRequest tokenRequest;
    private UserService userService = new UserService();
    private ScenarioContext scenarioContext;

    public GenerateToken(ScenarioContext context) {
        this.scenarioContext = context;
    }



    @When("^I generate token with username as (.*) and password as (.*)$")
    public void generateToken(String username, String password) {
        this.tokenRequest = userService.userCredentialRequest(username, password);
        this.tokenResponse = userService.tokenResponse(tokenRequest);
    }

    @When("^I generate token$")
    public void generateToken() {
        this.tokenRequest = (UserCredentialRequest) scenarioContext.getContext("UserRequest");
        this.tokenResponse = userService.tokenResponse(tokenRequest);
    }


    @Then("^I verify generate token successfully$")
    public void verifyGenerateTokenSuccessfully(){
        Assert.assertEquals(HttpStatus.SC_OK, this.tokenResponse .statusCode());
        Assert.assertEquals(this.tokenResponse.contentType(), GlobalConstant.CONTENT_TYPE);

        TokenResponse tokenResponse = this.tokenResponse.body().as(TokenResponse.class);
        Assert.assertNotNull(tokenResponse.getToken());
        Assert.assertEquals(tokenResponse.getStatus(), TokenStatus.SUCCESS.getValue());
        Assert.assertEquals(tokenResponse.getResult(), TokenResult.SUCCESS.getValue());
        LocalDate expiresDayActual = LocalDate.parse(tokenResponse.getExpires(), GlobalConstant.formatter);
        Assert.assertEquals(userService.getExpiredDate(), expiresDayActual);

        scenarioContext.setContext("Token", tokenResponse.getToken());
    }

    @Then("^I verify generate token failed$")
    public void verifyGenerateTokenFailed(){
        Assert.assertEquals(HttpStatus.SC_OK, this.tokenResponse.statusCode());
        Assert.assertEquals(this.tokenResponse.contentType(), GlobalConstant.CONTENT_TYPE);

        TokenResponse tokenResponse = this.tokenResponse.body().as(TokenResponse.class);
        Assert.assertNull(tokenResponse.getToken());
        Assert.assertNull(tokenResponse.getExpires());
        Assert.assertEquals(tokenResponse.getStatus(), TokenStatus.FAILED.getValue());
        Assert.assertEquals(tokenResponse.getResult(), TokenResult.FAILED.getValue());
    }
}
