package org.acme;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class OrderResourceTest {

    @Test
    public void testOrderHelloEndpoint() {
        given()
          .when().get("/orders/list")
          .then()
             .statusCode(200);
    }

}