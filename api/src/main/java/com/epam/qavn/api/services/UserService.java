package com.epam.qavn.api.services;

import com.epam.qavn.api.core.Route;
import com.epam.qavn.api.core.helpers.RestResource;
import com.epam.qavn.api.models.user.UserCredentialRequest;
import io.restassured.response.Response;

import java.time.LocalDate;

public class UserService {
    public Response tokenResponse(UserCredentialRequest userCredentialRequest) {
        return RestResource.post(Route.generateToken(), "", userCredentialRequest);
    }

    public UserCredentialRequest userCredentialRequest(String username, String password) {
        return new UserCredentialRequest(username, password);
    }

    public LocalDate getExpiredDate() {
        return LocalDate.now().plusDays(7);
    }

    public Response createUser(UserCredentialRequest userCredentialRequest) {
        return RestResource.post(Route.createUser(), "", userCredentialRequest);
    }

}
