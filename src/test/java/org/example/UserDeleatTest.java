package org.example;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class UserDeleatTest extends BaseClassForTest {
    @Test
    void deleteUser() {
        given()
                .spec(getRequestSpec())
                .when()
                .delete("/api/users/2")
                .then()
                .statusCode(204);
    }
}
