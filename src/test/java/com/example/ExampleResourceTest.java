package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ExampleResourceTest {

    @Test
    public void getOkResponse() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200);
    }

    @Test
    public void getExpectedResponse() {
        given()
                .when().get("/hello")
                .then()
                .body(is("Hello from RESTEasy Reactive"));
    }

}