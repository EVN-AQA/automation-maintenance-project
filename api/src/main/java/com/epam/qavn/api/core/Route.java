package com.epam.qavn.api.core;

public class Route {
    private static final String ACCOUNT = "/Account";
    private static final String BOOK = "/BookStore";
    private static final String VERSION = "/v1";

    public static String generateToken(){
        return ACCOUNT + VERSION + "/GenerateToken";
    }
    public static String createUser(){
        return ACCOUNT + VERSION + "/User";
    }
    public static String getBooks(){
        return BOOK + VERSION + "/Books";
    }
    public static String addBookToCollection(){
        return BOOK + VERSION + "/Books";
    }

}
