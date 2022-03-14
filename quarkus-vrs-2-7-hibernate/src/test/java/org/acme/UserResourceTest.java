package org.acme;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UserResourceTest {

    @Test
    public void testUserListEndpoint() {
        given()
          .when().get("/users/list")
          .then()
             .statusCode(200);
    }

}