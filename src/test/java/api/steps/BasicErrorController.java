package api.steps;

import base.TestVariables;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BasicErrorController {

    @Step("Basic Error Controller - GET/error")
    public int getErrorTest(String url) {
        Response response = given()
                .baseUri(TestVariables.API_BASE_URL)
                .when()
                .log().all()
                .get(url)
                .then().assertThat()
                .log().all()
                .extract().response();

        return response.getStatusCode();
    }
    @Step("Basic Error Controller - HEAD/error")
    public int headErrorTest(String url) {
        Response response = given()
                .baseUri(TestVariables.API_BASE_URL)
                .when()
                .log().all()
                .head(url)
                .then().assertThat()
                .log().all()
                .extract().response();

        return response.getStatusCode();
    }
    @Step("Basic Error Controller - POST/error")
    public int postErrorTest(String url) {
        Response response = given()
                .baseUri(TestVariables.API_BASE_URL)
                .when()
                .log().all()
                .post(url)
                .then().assertThat()
                .log().all()
                .extract().response();

        return response.getStatusCode();
    }
    @Step("Basic Error Controller - PUT/error")
    public int putErrorTest(String url) {
        Response response = given()
                .baseUri(TestVariables.API_BASE_URL)
                .when()
                .log().all()
                .put(url)
                .then().assertThat()
                .log().all()
                .extract().response();

        return response.getStatusCode();
    }
    @Step("Basic Error Controller - DELETE/error")
    public int deleteErrorTest(String url) {
        Response response = given()
                .baseUri(TestVariables.API_BASE_URL)
                .when()
                .log().all()
                .delete(url)
                .then().assertThat()
                .log().all()
                .extract().response();

        return response.getStatusCode();
    }
    @Step("Basic Error Controller - OPTIONS/error")
    public int optionsErrorTest(String url) {
        Response response = given()
                .baseUri(TestVariables.API_BASE_URL)
                .when()
                .log().all()
                .options(url)
                .then().assertThat()
                .log().all()
                .extract().response();

        return response.getStatusCode();
    }
    @Step("Basic Error Controller - PATCH/error")
    public int patchErrorTest(String url) {
        Response response = given()
                .baseUri(TestVariables.API_BASE_URL)
                .when()
                .log().all()
                .patch(url)
                .then().assertThat()
                .log().all()
                .extract().response();

        return response.getStatusCode();
    }
}
