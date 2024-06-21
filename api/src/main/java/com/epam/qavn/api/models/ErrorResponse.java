package com.epam.qavn.api.models;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class ErrorResponse {

    private String code;
    private String message;
    public ErrorResponse() {
    }

    public ErrorResponse(String code, String message) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ErrorResponse userNotAuthorized = (ErrorResponse) obj;
        return  (code == userNotAuthorized.code || (code != null && code.equals(userNotAuthorized.code)))&&
                (message == userNotAuthorized.message || (message != null && message.equals(userNotAuthorized.message)));
    }

}
