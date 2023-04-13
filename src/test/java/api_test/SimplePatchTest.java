package api_test;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class SimplePatchTest {
    private static final Logger LOGGER = LogManager.getLogger(SimplePatchTest.class);

    @Test
    public void updateUserSingleField(){
        LOGGER.info("---------API Test: Update user's single field---------");

        RestAssured.baseURI= "https://reqres.in/api/users";

        RequestSpecification httpRequest = RestAssured.given();

        Faker faker= new Faker();
        String userRoll = faker.job().title();
        LOGGER.debug("Updated User Job: " + userRoll);

        JSONObject reBody = new JSONObject();
        reBody.put("job", userRoll);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(reBody.toJSONString());

        String id= "2";
        Response response= httpRequest.request(Method.PATCH, id);
        LOGGER.info(response.getBody().asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath jsonPath= response.jsonPath();
        String actualJob = jsonPath.getString("job");

        Assert.assertEquals(actualJob, userRoll);

        LOGGER.info("---------End Test:  Update user's single field---------");

    }
}
