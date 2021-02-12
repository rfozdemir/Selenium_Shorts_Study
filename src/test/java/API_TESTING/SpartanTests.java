package API_TESTING;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpartanTests {
    String baseUrl = "https://reqres.in";

    @Test
    public void viewSpartanTest1() {
        Response response = RestAssured.get(baseUrl);
        System.out.println(response.statusCode());
        System.out.println(response.body().prettyPrint());
    }

    /*
    when user send GET request to api spartans end point
    Then status code must be 200
    And body should contains Allen for example
     */
    @Test
    public void viewSpartanTest2() {
        Response response = RestAssured.get(baseUrl + "/api/users?page=2");
        //verify status code 200
        Assert.assertEquals(response.statusCode(), 200);
        //verify body contains Allen
        Assert.assertTrue(response.body().asString().contains("Michael"));

    }

    /*
Given accept type is Json
When user sends a get request to spartanAllURL
Then response status code is 200
And response body should be json format

     */
    @Test
    public void SpartanTest3() {

      Response response=RestAssured.given().accept(ContentType.JSON).when().get(baseUrl+"/api/users?page=2");
      Assert.assertEquals(response.statusCode(),200);
        System.out.println(response.contentType());
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");

    }






}
