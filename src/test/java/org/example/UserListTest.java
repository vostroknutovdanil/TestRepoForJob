package org.example;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserListTest extends BaseClassForTest {

    @Test
    void checkUserEmails() {
        given()
                .spec(getRequestSpec())
                .when()
                .get("/api/users?page=2")
                .then()
                .spec(getResponseSpec())
                .statusCode(200)
                .body("data.email", everyItem(endsWith("@reqres.in")));
    }
}

