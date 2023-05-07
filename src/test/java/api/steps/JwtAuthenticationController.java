package api.steps;

import base.TestVariables;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class JwtAuthenticationController {
    @Step("Jwt Authentication Controller - POST api/login - createAuthenticationToken")
    public void createAuthenticationToken(String url, int response) {
        given().
                baseUri(TestVariables.API_BASE_URL).
        when().
                log().all().
                get(url).
        then().assertThat().
                log().all().
                statusCode(response);
    }
}
