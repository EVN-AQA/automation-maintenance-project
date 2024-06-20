package com.epam.qavn.api.models.user;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class CreateUserResponse_400 {

    private String code;
    private String message;

    public CreateUserResponse_400() {
    }

    public CreateUserResponse_400(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}