package API_TESTING;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import static io.restassured.RestAssured.*;

public class HamcrestTest {
    public void setup(){
        baseURI="";



    }
    @Test
    public void test1(){
        //request
       given().accept(ContentType.JSON).pathParam("id",15)
               .when().get("/api/spartans/{id}")
               //response
        .then().statusCode(200).and().assertThat()
               .contentType("application/json:charset=UTF-8");

    }


    /*
    given accept type is Json
    and path param id is 15
    when user sends a get request to spartans/{id}
    Then status code is 200
    and content type is Json
    and json following
    "id" : 15,
    "name" : "Meta",
    "gender" : "Female",
    "phone" : "1214$124"
     */

    @Test
    public void test2(){
        // you can make hamcrest static above and you don't need to call Matchers every time.
        //request
        given().accept(ContentType.JSON).pathParam("id",15)
                .when().get("/api/spartans/{id}")
                //Response
                .then().assertThat().statusCode(200).and().assertThat().contentType("application/json:charset=UTF-8")
                .and().assertThat()
                .body("id", Matchers.equalTo(15),"name",Matchers.equalTo("Meta"),
                        "gender",Matchers.equalTo("Female"),"phone",Matchers.equalTo("123124124"));
                /*Basically hamcrest is a framework and assisting you to test in Java and provides you custom
                assertions with Matchers. It makes your job easier. you can verify your response body with that class.

                * */






    }














}
