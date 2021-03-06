package ru.levelup.qa.at.api.rest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.api.UserApiObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class ReqResWithObjectsApiTest {

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
        UserApiObject user = new UserApiObject();
        user.setName("Jane");
        user.setJob("developer");
        UserApiObject apiObjectResponse = given()
                .spec(requestSpecification)
                .body(user)
                .when()
                .post("/api/users")
                .then()
                .spec(responseSpecification)
                .statusCode(201)
                .extract()
                .as(UserApiObject.class);

        assertThat(apiObjectResponse, samePropertyValuesAs(user, "id", "createdAt"));
    }

    @Test
    public void updatedUserTest() {
        UserApiObject userApiObject = new UserApiObject("Jane", "leader");
        UserApiObject responseObject = given()
                .spec(requestSpecification)
                .body(userApiObject)
                .when()
                .put("/api/users/2")
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("name", equalTo("Jane"))
                .body("job", equalTo("leader"))
                .body("updatedAt", containsString("2020-10-22"))
                .extract().as(UserApiObject.class);

        System.out.println(responseObject);
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
