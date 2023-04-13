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

public class SimplePutTest {
    private static final Logger LOGGER = LogManager.getLogger(SimplePostTest.class);

    @Test
    public void updateUserFields(){
        LOGGER.info("---------API Test: Update user Records---------");

        RestAssured.baseURI= "https://reqres.in/api/users";

        RequestSpecification httpRequest = RestAssured.given();

        Faker faker= new Faker();
        String fullName= faker.name().fullName();
        LOGGER.debug("New Updated Full name:" + fullName);

        String userRoll = faker.job().title();
        LOGGER.debug("Updated User Job: " + userRoll);

        JSONObject reBody = new JSONObject();
        reBody.put("name", fullName);
        reBody.put("job", userRoll);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(reBody.toJSONString());

        String id= "2";
        Response response= httpRequest.request(Method.PUT, id);
        LOGGER.info(response.getBody().asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath jsonPath= response.jsonPath();
        String actualName = jsonPath.getString("name");
        String actualJob = jsonPath.getString("job");

        Assert.assertEquals(actualName, fullName);
        Assert.assertEquals(actualJob, userRoll);

        LOGGER.info("---------End Test: Update user Records----------");

    }
}
