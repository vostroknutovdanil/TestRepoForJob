package org.example;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RegistrationTestForUser extends BaseClassForTest {

    @Test
    void successfulRegistration() {
        String requestBody = """
                {
                    "email": "eve.holt@reqres.in",
                    "password": "pistol"
                }
                """;

        given()
                .spec(getRequestSpec())
                .body(requestBody)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .spec(getResponseSpec())
                .statusCode(200)
                .body("id", notNullValue())
                .body("token", notNullValue());
    }

    @Test
    void registrationWithoutPassword() {
        String requestBody = """
                {
                    "email": "eve.holt@reqres.in"
                }
                """;

        given()
                .spec(getRequestSpec())
                .body(requestBody)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(400)
                .body("error", equalTo("Missing password"));
    }


}
