package api;

import base.BaseClass;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class StatusCodesControllerTest extends BaseClass {
    @Test(priority = 1, description = "status-codes-controller - api/bad request")
    public void testStatusCodeControllerBadRequest() {
        String response = given().
                log().all().
                when().
                get("http://85.192.34.140:8080/api/bad-request").
                then().
                assertThat().
                statusCode(400).
                extract().
                asString();

        System.out.println(response);
    }
    @Test(priority = 2, description = "status-codes-controller - api/created")
    public void testStatusCodeControllerCreated() {
        String response = given().
                log().all().
                when().
                get("http://85.192.34.140:8080/api/created").
                then().
                assertThat().
                statusCode(201).
                extract().
                asString();

        System.out.println(response);
    }
    @Test(priority = 3, description = "status-codes-controller - api/forbidden")
    public void testStatusCodeControllerForbidden() {
        String response = given().
                log().all().
                when().
                get("http://85.192.34.140:8080/api/forbidden").
                then().
                assertThat().
                statusCode(403).
                extract().
                asString();

        System.out.println(response);
    }
}