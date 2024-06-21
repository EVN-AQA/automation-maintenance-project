package com.epam.qavn.api.models.user;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class UserCredentialRequest {
    public String userName;
    public String password;

    public UserCredentialRequest() {
    }

    public UserCredentialRequest(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }
}
