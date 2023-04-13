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

import java.util.List;

public class GetTestWithQueryParameter {

    private static final Logger LOGGER= LogManager.getLogger(GetTestWithQueryParameter.class);

    @Test
    public void getUserWithQueryParameter(){
        LOGGER.info("------API Test: Get All users With Query Parameter------");

        //Specify the URL or Endpoint of Rest API
        RestAssured.baseURI= "https://reqres.in/api/users";

        //The server is specified in the base url that we specified in the above step.
        RequestSpecification httpRequest= RestAssured.given();

        //Make a request to the server by the specifying HTTP Method type.
        Response response = httpRequest.queryParam("page", "2").request(Method.GET);
        LOGGER.debug(response.getBody().asString());

        //Assert that the correct response status code is returned
        Assert.assertEquals(response.getStatusCode(),200);

        //Get the jsonPath object from the response
        JsonPath jsonPath= response.jsonPath();
        List<String> list= jsonPath.get("data.email");

        //Validate that a specific user email does not exist in the response body.
        String emailId= "michael.lawson@reqres.in";
        boolean emailExist = list.contains(emailId);
        Assert.assertTrue(emailExist, emailId + "dose not exist");

        LOGGER.info("------END Test: Get All users With Query Parameter------");

    }
}
