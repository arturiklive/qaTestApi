package api.tests;

import api.steps.BasicErrorController;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BasicErrorControllerTest {
    private BasicErrorController basicErrorController = new BasicErrorController();

    @Test
    public void testGetErrorReturns401() {
        int statusCode = basicErrorController.getErrorTest("error");
        assertEquals(statusCode, 401, "Expected 401 status code");
    }

    @Test
    public void testHeadErrorReturns401() {
        int statusCode = basicErrorController.headErrorTest("error");
        assertEquals(statusCode, 401, "Expected 401 status code");
    }

    @Test
    public void testPostErrorReturns401() {
        int statusCode = basicErrorController.postErrorTest("error");
        assertEquals(statusCode, 401, "Expected 401 status code");
    }

    @Test
    public void testPutErrorReturns401() {
        int statusCode = basicErrorController.putErrorTest("error");
        assertEquals(statusCode, 401, "Expected 401 status code");
    }

    @Test
    public void testDeleteErrorReturns401() {
        int statusCode = basicErrorController.deleteErrorTest("error");
        assertEquals(statusCode, 401, "Expected 401 status code");
    }

    @Test
    public void testOptionsErrorReturns401() {
        int statusCode = basicErrorController.optionsErrorTest("error");
        assertEquals(statusCode, 401, "Expected 401 status code");
    }

    @Test
    public void testPatchErrorReturns401() {
        int statusCode = basicErrorController.patchErrorTest("error");
        assertEquals(statusCode, 401, "Expected 401 status code");
    }
}
