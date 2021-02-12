package API_TESTING;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class QueryParams {
    @BeforeClass
    public void setup(){
        //RestAssured.   I put "static" and "*" in Rest assured library that's why I do not need to call RestAssured every time

        baseURI = "https://reqres.in";
    }
    /*
    Given accept type is JSON
    And query parameter values are :
    gender | female
    nameContains | J
    When user sends GET request to /api/spartans/search
    Then response status code should be 200
    And response content-type: application/json;charset=UTF-8
    And "Female" should be in response payload
    And "Janette" should be in response payload

     */
    @Test
    public void testQueryParam1(){
        Response response= RestAssured.given().accept(ContentType.JSON)
               .and().queryParam("page",2   ) // I can declare more than one query parameter and also I can gather them in Map like I did in another method below
                .and().when().get("/api/users");

       //verify status code
        Assert.assertEquals(response.statusCode(),200);
        //verify content type
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");

        //verify a  string such as gender "female" or a name
        Assert.assertTrue(response.body().asString().contains("Lindsay"));
        Assert.assertTrue(response.body().asString().contains("tobias.funke@reqres.in"));

        //System.out.println(response.body().asString());
        System.out.println(response.body().prettyPrint());


    }
@Test
public void queryParams2(){
        /*
        If you wanna run these code you have to have documentation like  key and value format
    and this documentation has to include query parameters and their value
    and there should be available values
    QUERY PARAM           VALUE
    "gender"         male or female
    "nameContains"         "J"


        */

        //creating map for query Params
    Map<String,Object> paramsMap=new HashMap<>();
    paramsMap.put("gender","Female");
    paramsMap.put("nameContains","J");

    //send request
    Response response=RestAssured.given().accept(ContentType.JSON)
            .and().queryParams(paramsMap)
            .when().get("/api/users");

    //verify status code
    Assert.assertEquals(response.statusCode(),200);
    //verify content type
    Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");

    //verify a  string such as gender "female" or a name
    Assert.assertTrue(response.body().asString().contains("Lindsay"));
    Assert.assertTrue(response.body().asString().contains("tobias.funke@reqres.in"));

    //System.out.println(response.body().asString());
    System.out.println(response.body().prettyPrint());




}



}
