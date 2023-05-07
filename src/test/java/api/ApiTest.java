package api;

import api.steps.BasicErrorController;
import api.steps.JwtAuthenticationController;
import org.testng.annotations.Test;


public class ApiTest {
    public String token;
    @Test
    public void getToken() {
        JwtAuthenticationController jwtAuthenticationController = new JwtAuthenticationController();
        token = jwtAuthenticationController.createAuthenticationToken("api/login", 200);
        System.out.println(token);
    }
    @Test
    public void BasicErrorControllerTest() {
        BasicErrorController basicErrorController = new BasicErrorController();
        basicErrorController.getErrorTest("error", 401);
        basicErrorController.headErrorTest("error", 401);
        basicErrorController.postErrorTest("error", 401);
        basicErrorController.putErrorTest("error", 401);
        basicErrorController.deleteErrorTest("error", 401);
        basicErrorController.optionsErrorTest("error", 401);
        basicErrorController.patchErrorTest("error", 401);
    }

}
