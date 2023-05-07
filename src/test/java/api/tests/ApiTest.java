package api.tests;

import api.steps.GameController;
import api.steps.JwtAuthenticationController;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ApiTest {
    public String token;
    GameController gameController = new GameController();
    @Test(priority = 1)
    public void getTokenTest() {
        JwtAuthenticationController jwtAuthenticationController = new JwtAuthenticationController();
        token = jwtAuthenticationController.createAuthenticationToken("api/login", 200);
        System.out.println(token);
    }
    @Test(priority = 2)
    public void gameControllerTestWithoutToken() {
        int statusCode = gameController.getGamesNoToken("error");
        assertEquals(statusCode, 401, "Expected 401 status code");
    }

    @Test(priority = 3)
    public void gameControllerTestWithToken() {
        int statusCode = gameController.getGamesToken("api/user/games", token);
        assertEquals(statusCode, 200, "Expected 200 status code");
    }

}
