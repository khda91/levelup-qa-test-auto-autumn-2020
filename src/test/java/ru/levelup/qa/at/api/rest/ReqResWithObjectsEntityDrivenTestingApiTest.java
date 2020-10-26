package ru.levelup.qa.at.api.rest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.qa.at.api.UserApiObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class ReqResWithObjectsEntityDrivenTestingApiTest {

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

    // yyyyMMdd || yyyy-MM-dd

    @DataProvider
    public Object[][] usersDataProvider() {
        return new Object[][] {
                {new UserApiObject("Jane", "developer")},
                {new UserApiObject("John", "leadeR")},
                {new UserApiObject("Петруха", "свой")}
        };
    }

    @Test(dataProvider = "usersDataProvider")
    public void updatedUserTest(UserApiObject userBodyObject) {
        UserApiObject responseObject = given()
                .spec(requestSpecification)
                .body(userBodyObject)
                .when()
                .put("/api/users/2")
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .extract().as(UserApiObject.class);

        assertThat(responseObject, samePropertyValuesAs(userBodyObject, "id", "updatedDate", "createdAt"));

        System.out.println(responseObject);
    }
}
