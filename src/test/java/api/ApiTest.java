package api;

import api.steps.BasicErrorController;
import org.testng.annotations.Test;


public class ApiTest {
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
