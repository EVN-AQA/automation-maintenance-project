package com.epam.qavn.api.core.helpers;

import com.epam.qavn.api.core.GlobalConstant;
import com.epam.qavn.api.utils.PropertyReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Builder {
    static String baseUri = new PropertyReader(GlobalConstant.CONFIG_FILE_KEY).getValue(GlobalConstant.BASE_URI);

    static RequestSpecification getRequestSpec()  {
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                log(LogDetail.ALL).
                build();
    }
}
