package org.example.company.controller;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionComponentTest {

    @LocalServerPort
    private int port;

    @Test
    public void testApplicationEndToEnd() {
        Integer accountNumber = 12345;

        given()
                .when()
                .get(String.format("http://localhost:%s/api/v1/transactions/%s", port, accountNumber))
                .then()
                .statusCode(is(200));
    }
}
