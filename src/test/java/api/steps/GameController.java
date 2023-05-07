package api.steps;

import base.TestVariables;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GameController {
    @Step("game-controller - Game Controller - GET /api/user/games getGames - NO TOKEN TEST")
    public int getGamesNoToken(String url) {
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

    @Step("game-controller - Game Controller - GET /api/user/games getGames - WITH TOKEN")
    public int getGamesToken(String url, String token) {
        Response response = given()
                .baseUri(TestVariables.API_BASE_URL)
                .header("Authorization", "Bearer " + token)
                .when()
                .log().all()
                .get(url)
                .then().assertThat()
                .log().all()
                .extract().response();

        return response.getStatusCode();
    }
}
