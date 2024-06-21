package com.epam.qavn.api.core;

import java.time.format.DateTimeFormatter;

public class GlobalConstant {

    public static final String CONFIG_FILE_KEY = "config";
    public static final String BASE_URI = "base.uri";
    public static final String CONTENT_TYPE = "application/json; charset=utf-8";
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
}
