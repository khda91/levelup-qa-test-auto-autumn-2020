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

public class ReqResWithObjectsDataDrivenTestingApiTest {

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
                {"Jane", "developer"},
                {"John", "leadeR"},
                {"Петруха", "свой"}
        };
    }

    @Test(dataProvider = "usersDataProvider")
    public void createUserTest(String name, String job) {
        UserApiObject user = new UserApiObject();
        user.setName(name);
        user.setJob(job);
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
}
