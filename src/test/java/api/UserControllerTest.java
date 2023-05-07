package api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserControllerTest {
    private String userToken;

    @Test(priority = 1, description = "user-controller - POST register")
    public void testUserControllerPostRegister() {
        String jsonBody = "{\n" +
                "  \"games\": [\n" +
                "    {\n" +
                "      \"company\": \"string\",\n" +
                "      \"description\": \"string\",\n" +
                "      \"dlcs\": [\n" +
                "        {\n" +
                "          \"description\": \"string\",\n" +
                "          \"dlcName\": \"string\",\n" +
                "          \"isDlcFree\": true,\n" +
                "          \"price\": 0,\n" +
                "          \"rating\": 0,\n" +
                "          \"similarDlc\": {\n" +
                "            \"dlcNameFromAnotherGame\": \"string\",\n" +
                "            \"free\": true\n" +
                "          }\n" +
                "        }\n" +
                "      ],\n" +
                "      \"gameId\": 0,\n" +
                "      \"genre\": \"string\",\n" +
                "      \"isFree\": true,\n" +
                "      \"price\": 0,\n" +
                "      \"publish_date\": \"2023-04-25T07:01:22.856Z\",\n" +
                "      \"rating\": 0,\n" +
                "      \"requiredAge\": true,\n" +
                "      \"requirements\": {\n" +
                "        \"hardDrive\": 0,\n" +
                "        \"osName\": \"string\",\n" +
                "        \"ramGb\": 0,\n" +
                "        \"videoCard\": \"string\"\n" +
                "      },\n" +
                "      \"tags\": [\n" +
                "        \"string\"\n" +
                "      ],\n" +
                "      \"title\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"id\": 0,\n" +
                "  \"login\": \"string\",\n" +
                "  \"pass\": \"string\"\n" +
                "}";

        String response = given().
                    log().all().
                when().
                    contentType(ContentType.JSON).
                    body(jsonBody).
                    post("http://85.192.34.140:8080/api/register").
                then().
                assertThat().
                statusCode(400).
                extract().
                asString();

        System.out.println(response);
    }
    @Test(priority = 2, description = "POST Jwt Authentication Controller - We will get TOKEN")
    public void testJwtAuthenticationControllerPost() {
        String jsonBody = "{\n" +
                "  \"password\": \"string\",\n" +
                "  \"username\": \"string\"\n" +
                "}";

        String token = given().
                log().all().
                when().
                contentType(ContentType.JSON).
                body(jsonBody).
                post("http://85.192.34.140:8080/api/login").
                then().
                assertThat().
                statusCode(200).
                extract().response().jsonPath().getString("token");

        userToken = token;
        System.out.println("Your token is: " + token);
    }
    @Test(priority = 3, description = "User Controller: DELETE USER using token from test 2")
    public void testUserControllerDeleteUser() {
        String response = given().
                log().all().
                contentType(ContentType.JSON).
                header("-H", "Authorization:" + userToken).
                when().
                delete("http://85.192.34.140:8080/api/user").
                then().
                assertThat().
                statusCode(401).
                extract().
                asString();

        System.out.println(response);
    }
}