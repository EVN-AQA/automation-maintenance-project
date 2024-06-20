package com.epam.qavn.api.core.helpers;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import io.restassured.response.Response;

import java.util.Optional;

import static com.epam.qavn.api.core.helpers.Builder.getRequestSpec;
import static com.epam.qavn.api.core.helpers.Builder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response post(String path, String token, @Nullable Object params)  {

        return given(getRequestSpec())
                .auth().oauth2(token)
                .body(params)
                .when()
                .post(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }


    public static Response get(String path, String token)  {
        return given(getRequestSpec())
                .auth().oauth2(token)
                .when()
                .get(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response put(String path, Object params, String token) {
        return given(getRequestSpec())
                .auth().oauth2(token)
                .body(params)
                .when()
                .put(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response delete(String path, String token, Object... params) {
        return given(getRequestSpec())
                .auth().oauth2(token)
                .body(params)
                .when()
                .delete(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }


}
