package api.steps;

import base.TestVariables;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class JwtAuthenticationController {
    public String createAuthenticationTokenBody = "{\n" +
            "  \"password\": \"string\",\n" +
            "  \"username\": \"string\"\n" +
            "}";

    @Step("Jwt Authentication Controller - POST api/login - createAuthenticationToken")
    public String createAuthenticationToken(String url, int response) {
        Response httpResponse =
                given()
                        .baseUri(TestVariables.API_BASE_URL)
                        .contentType(ContentType.JSON)
                        .body(createAuthenticationTokenBody)
                        .when()
                        .log().all()
                        .post(url)
                        .then()
                        .log().all()
                        .statusCode(response)
                        .extract()
                        .response();

        return httpResponse.path("token");
    }
}
