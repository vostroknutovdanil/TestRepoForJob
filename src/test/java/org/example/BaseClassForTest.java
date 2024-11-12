package org.example;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class BaseClassForTest {

    private static final RequestSpecification requestSpec;
    private static final ResponseSpecification responseSpec;

    static {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setContentType("application/json")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectContentType("application/json")
                .build();
    }

    public static RequestSpecification getRequestSpec() {
        return requestSpec;
    }

    public static ResponseSpecification getResponseSpec() {
        return responseSpec;
    }
}
