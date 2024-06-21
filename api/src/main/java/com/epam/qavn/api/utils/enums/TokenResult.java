package com.epam.qavn.api.utils.enums;

public enum TokenResult {
    SUCCESS("User authorized successfully."),
    FAILED("User authorization failed.");

    private final String value;

    TokenResult(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
