package api.steps;

import base.TestVariables;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class BasicErrorController {

    @Step("Basic Error Controller - GET/error")
    public void getErrorTest(String url, int response) {
        given().
                baseUri(TestVariables.API_BASE_URL).
        when().
                log().all().
                get(url).
        then().assertThat().
                log().all().
                statusCode(response);
    }
    @Step("Basic Error Controller - HEAD/error")
    public void headErrorTest(String url, int response) {
        given().
                baseUri(TestVariables.API_BASE_URL).
                when().
                log().all().
                head(url).
                then().assertThat().
                log().all().
                statusCode(response);
    }
    @Step("Basic Error Controller - POST/error")
    public void postErrorTest(String url, int response) {
        given().
                baseUri(TestVariables.API_BASE_URL).
                when().
                log().all().
                post(url).
                then().assertThat().
                log().all().
                statusCode(response);
    }
    @Step("Basic Error Controller - PUT/error")
    public void putErrorTest(String url, int response) {
        given().
                baseUri(TestVariables.API_BASE_URL).
                when().
                log().all().
                put(url).
                then().assertThat().
                log().all().
                statusCode(response);
    }
    @Step("Basic Error Controller - DELETE/error")
    public void deleteErrorTest(String url, int response) {
        given().
                baseUri(TestVariables.API_BASE_URL).
                when().
                log().all().
                delete(url).
                then().assertThat().
                log().all().
                statusCode(response);
    }
    @Step("Basic Error Controller - OPTIONS/error")
    public void optionsErrorTest(String url, int response) {
        given().
                baseUri(TestVariables.API_BASE_URL).
                when().
                log().all().
                options(url).
                then().assertThat().
                log().all().
                statusCode(response);
    }
    @Step("Basic Error Controller - PATCH/error")
    public void patchErrorTest(String url, int response) {
        given().
                baseUri(TestVariables.API_BASE_URL).
                when().
                log().all().
                patch(url).
                then().assertThat().
                log().all().
                statusCode(response);
    }
}
