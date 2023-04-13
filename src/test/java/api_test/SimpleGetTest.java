package api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.asynchttpclient.Request;
import org.junit.Test;
import org.openqa.selenium.devtools.v108.fetch.model.AuthChallengeResponse;
import org.testng.Assert;

import java.util.List;

public class SimpleGetTest {
    private static final Logger LOGGER= LogManager.getLogger(SimpleGetTest.class);

    @Test
    public void getAllUsers(){
        LOGGER.info("------API Test: Get All users------");

        //Specify the URL or Endpoint of Rest API
        RestAssured.baseURI= "https://reqres.in/api/users";

        //The server is specified in the base url that we specified in the above step.
        RequestSpecification httpRequest= RestAssured.given();

        //Make a request to the server by the HTTP
        Response response = httpRequest.request(Method.GET);
        LOGGER.debug(response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(),200);

        JsonPath jsonPath= response.jsonPath();
        List<String> list= jsonPath.get("data.email");

        String emailId= "george.bluth@reqres.in";
        boolean emailExist = list.contains(emailId);
        Assert.assertTrue(emailExist, emailId + "dose not exist");

        LOGGER.info("------END Test: Get All users------");

    }
}
