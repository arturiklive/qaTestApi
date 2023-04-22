package api;

import base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiBasicErrorControllerTest extends BaseClass {
    @Test(priority = 1)
    public void testGetRequest() {
        given().
                when().
                get("http://85.192.34.140:8080/swagger-ui/error").
                then().
                assertThat().
                statusCode(404);
    }

    //Проверка, что запрос к /error возвращает 200 OK
    @Test(priority = 2)
    public void testGetErrorReturns200() {
        Response response = RestAssured.get("http://85.192.34.140:8080/swagger-ui/error");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
    //Проверка, что запрос к /error возвращает 401 Unauthorized, если пользователь не авторизован
    @Test(priority = 3)
    public void testGetErrorReturns401() {
        RestAssured.authentication = RestAssured.basic("username", "password");
        Response response = RestAssured.get("http://85.192.34.140:8080/swagger-ui/error");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 401);
    }

    //Проверка, что запрос к /error возвращает 403 Forbidden, если у пользователя нет необходимых прав доступа
    @Test(priority = 4)
    public void testGetErrorReturns403() {
        RestAssured.authentication = RestAssured.basic("username", "password");
        Response response = RestAssured.get("http://85.192.34.140:8080/swagger-ui/error");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 403);
    }
    //Проверка, что запрос к /error возвращает 404 Not Found, если ендпоинт недоступен
    @Test(priority = 5)
    public void testGetErrorReturns404() {
        Response response = RestAssured.get("http://85.192.34.140:8080/swagger-ui/error-invalid");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404);
    }
}