package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {
    private final String BASE_URL = "https://postman-echo.com";

    @Test
    public void testGetRequest() {
        Response response = given()
            .queryParam("param", "123")
        .when()
            .get(BASE_URL + "/get")
        .then()
            .statusCode(200)
            .extract().response();

        
        Assert.assertEquals(response.jsonPath().getString("args.param"), "123");
        Assert.assertTrue(response.jsonPath().getString("headers.host").contains("postman-echo.com"));
        Assert.assertTrue(response.jsonPath().getString("url").contains("/get?param=123"));
    }

    @Test
    public void testPostRequest() {
        String requestBody = "{\"name\": \"John\", \"age\": 30}";

        Response response = given()
            .header("Content-Type", "application/json")
            .body(requestBody)
        .when()
            .post(BASE_URL + "/post")
        .then()
            .statusCode(200)
            .extract().response();

        Assert.assertEquals(response.jsonPath().getString("data.name"), "John");
        Assert.assertEquals(response.jsonPath().getInt("data.age"), 30);
        Assert.assertEquals(response.jsonPath().getString("json"), null);
    

    @Test
    public void testPutRequest() {
        String requestBody = "{\"name\": \"John2\"}";

        Response response = given()
            .header("Content-Type", "application/json")
            .body(requestBody)
        .when()
            .put(BASE_URL + "/put")
        .then()
            .statusCode(200)
            .extract().response();

        Assert.assertEquals(response.jsonPath().getString("data.name"), "John2");
        Assert.assertEquals(response.jsonPath().getString("json"), null);
    }

    @Test
    public void testPatchRequest() {
        String requestBody = "{\"age\": 31}";

        Response response = given()
            .header("Content-Type", "application/json")
            .body(requestBody)
        .when()
            .patch(BASE_URL + "/patch")
        .then()
            .statusCode(200)
            .extract().response();

        Assert.assertEquals(response.jsonPath().getInt("data.age"), 31);
        Assert.assertEquals(response.jsonPath().getInt("json"), null);
    }

    @Test
    public void testDeleteRequest() {

        String requestBody = "{\"age\": 31}";

        Response response = given()
        .body(requestBody)
        .when()
            .delete(BASE_URL + "/delete")
        .then()
            .statusCode(200)
            .extract().response();

        Assert.assertEquals(response.jsonPath().getInt("data.age"), 31);
        Assert.assertEquals(response.jsonPath().getInt("json"), null);
        Assert.assertTrue(response.jsonPath().getString("headers.host").contains("postman-echo.com"));
        Assert.assertTrue(response.jsonPath().getString("url").contains("/delete"));
    }
} 