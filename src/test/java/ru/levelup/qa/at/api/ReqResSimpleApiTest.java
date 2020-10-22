package ru.levelup.qa.at.api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class ReqResSimpleApiTest {

    @Test
    public void createUserTest() {
        given()
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in")
                .body("{" +
                        "\"name\" : \"Jane\"," +
                        "\"job\" : \"developer\"" +
                        "}")
                .log().all()
                .when()
                .post("/api/users")
                .then()
                .log().all()
                .statusCode(201)
                .body("id", not(equalTo("")))
                .body("name", equalTo("Jane"))
                .body("job", equalTo("developer"))
                .body("createdAt", containsString("2020-10-22"));
    }
}
