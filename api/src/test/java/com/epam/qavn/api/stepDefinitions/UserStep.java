package com.epam.qavn.api.stepDefinitions;

import com.epam.qavn.api.core.GlobalConstant;
import com.epam.qavn.api.models.user.CreateUserResponse_200;
import com.epam.qavn.api.models.user.CreateUserResponse_400;
import com.epam.qavn.api.models.user.UserCredentialRequest;
import com.epam.qavn.api.services.UserService;
import com.epam.qavn.api.utils.JsonLoader;
import com.epam.qavn.api.utils.RandomUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.commons.httpclient.HttpStatus;
import org.junit.Assert;

public class UserStep {
    private Response createUserResponse;
    private UserCredentialRequest userCredentialRequest;
    private UserService userService = new UserService();

    private ScenarioContext scenarioContext;


    public UserStep(ScenarioContext context) {
        this.scenarioContext = context;
    }


    @When("^I create user with password as (.*)$")
    public void getUserInfo(String password) {
        String username = new RandomUtil().getRandomString(8);
        this.userCredentialRequest = userService.userCredentialRequest(username, password);
        this.createUserResponse = userService.createUser(userCredentialRequest);
    }

    @Then("^I verify create user successfully$")
    public void verifyGetUserInfoSuccessfully(){
        Assert.assertEquals(HttpStatus.SC_CREATED, this.createUserResponse .statusCode());
        Assert.assertEquals(this.createUserResponse.contentType(), GlobalConstant.CONTENT_TYPE);

        CreateUserResponse_200 userResponse = this.createUserResponse.body().as(CreateUserResponse_200.class);
        Assert.assertNotNull(userResponse.getUserID());
        Assert.assertEquals(userResponse.getUsername(), userCredentialRequest.userName);
        Assert.assertTrue(userResponse.getBooks().isEmpty());

        scenarioContext.setContext("UserRequest", userCredentialRequest);
        scenarioContext.setContext("UserResponse", userResponse);
    }

    @Then("^I verify create user failed with invalid password$")
    public void verifyGetUserInfoFailed() {
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, this.createUserResponse .statusCode());
        Assert.assertEquals(this.createUserResponse.contentType(), GlobalConstant.CONTENT_TYPE);

        CreateUserResponse_400 userResponseActual = this.createUserResponse.body().as(CreateUserResponse_400.class);
        String filePath = "src/test/resources/testdata/CreateUserWithInvalidPassword.json";
        CreateUserResponse_400 userResponseExpected = new JsonLoader().readJsonFile(filePath, CreateUserResponse_400.class);
        Assert.assertEquals(userResponseExpected.getMessage(), userResponseActual.getMessage());
        Assert.assertEquals(userResponseExpected.getCode(), userResponseActual.getCode());
    }
}
