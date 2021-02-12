package API_TESTING;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static org.testng.Assert.*;
// if you make here static Assert then you do not need to put "Assert" part in assertions below
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PathParam {



    @BeforeClass
    public void setUpClass() {
        RestAssured.baseURI = "https://reqres.in";
    }
     /*
     POSITIVE PATH PARAM SCENARIO
    Given accept type is json
    and Id parameter value is 18
    When user  sends Get request to /api/spartans/{id}
    Then response status code
     And response content-type : application/json; charset=UTF-8
     And "Allen" should be in response payload
     */

    @Test
    public void PathTest1() {
        Response response = RestAssured.given().accept(ContentType.JSON).
                and().
                pathParam("id", 3).
                when().get("/api/users/{id}");
        //verify status code
        assertEquals(response.statusCode(), 200);
        //verify content type
        assertEquals(response.contentType(), "application/json; charset=utf-8");
        //verify a string exists
        Assert.assertTrue(response.body().asString().contains("Emma"));
        //verify Allen exists
        System.out.println(response.body().prettyPrint());

    }

    /*



    NEGATIVE PATH PARAM SCENARIO
    Given accept type is JSON
    and Id parameter value is 500
    When user sends GET request to/api/spartans/{id}
    Then response status code should be 404
     And response content-type : application/json; charset=UTF-8
     And "Spartan not found" message should be in response payload

     */
@Test
public void Test2 (){
    Response response = RestAssured.given().accept(ContentType.JSON)
            .pathParam("id",500).when().get("/api/users/{id}");
            assertEquals(response.statusCode(),404);
            assertEquals(response.contentType(),"application/json; charset=utf-8");

    System.out.println(response.body().prettyPrint());
    assertFalse(response.body().asString().contains("User is not found"));

}
//chicano : people who was born in US but originally are from Mexico

}
