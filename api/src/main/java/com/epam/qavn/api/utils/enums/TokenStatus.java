package com.epam.qavn.api.utils.enums;

public enum TokenStatus {
    SUCCESS("Success"),
    FAILED("Failed");

    private final String value;

    TokenStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
