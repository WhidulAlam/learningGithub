package api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.testng.Assert;


public class GetTestWithVariables{
    private static final Logger  LOGGER= LogManager.getLogger(GetTestWithVariables.class);

    @Test
    public void attemptToGetWithInvalidId(){
        LOGGER.info("----------API test: Attempt to retrieve user with invalid id------------");

        RestAssured.baseURI= "https://reqres.in/api/users";

        RequestSpecification httpRequest= RestAssured.given();
        String id= "23";
        Response response= httpRequest.request(Method.GET, id);
        LOGGER.debug(response.getBody().asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 404);

        JsonPath jsonPath= response.jsonPath();
        String actualResponse = jsonPath.get().toString();

        Assert.assertEquals(actualResponse, "{}");

        LOGGER.info(("----------API test: Attempt to retrieve user with invalid id------------"));
    }
}
