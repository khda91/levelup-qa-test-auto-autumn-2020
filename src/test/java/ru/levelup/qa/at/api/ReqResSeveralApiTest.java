package ru.levelup.qa.at.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class ReqResSeveralApiTest {

    RequestSpecification requestSpecification;

    ResponseSpecification responseSpecification;

    @BeforeMethod
    public void setUp() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }

    @Test
    public void createUserTest() {
        given()
                .spec(requestSpecification)
                .body("{" +
                        "\"name\" : \"Jane\"," +
                        "\"job\" : \"developer\"" +
                        "}")
                .when()
                .post("/api/users")
                .then()
                .spec(responseSpecification)
                .statusCode(201)
                .body("id", not(equalTo("")))
                .body("name", equalTo("Jane"))
                .body("job", equalTo("developer"))
                .body("createdAt", containsString("2020-10-22"));
    }

    @Test
    public void updatedUserTest() {
        given()
                .spec(requestSpecification)
                .body("{" +
                        "\"name\" : \"Jane\"," +
                        "\"job\" : \"leader\"" +
                        "}")
                .log().all()
                .when()
                .put("/api/users/2")
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("name", equalTo("Jane"))
                .body("job", equalTo("leader"))
                .body("updatedAt", containsString("2020-10-22"));
    }

    @Test
    public void loginUserTest() {
        given()
                .spec(requestSpecification)
                .body("{" +
                        "\"email\" : \"eve.holt@reqres.in\"," +
                        "\"password\" : \"leader\"" +
                        "}")
                .log().all()
                .when()
                .post("/api/login")
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("token", not(equalTo("")));
    }
}
