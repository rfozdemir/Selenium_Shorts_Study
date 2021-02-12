package API_TESTING;

import  static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.testng.Assert.*;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;

public class PathParametersByUsingPath {

    @BeforeClass
    public void setUpClass(){
        baseURI = "https://reqres.in";
    }
    /*
    Given accept type is json
    and path param id is 10
    when user sends a get request to "/spartans/{id}"
    Then status code is 200
    And content- type is "application/json:char"
    And response payload values match the following:
    id is 10,
    names is "Lorenza",
    gender is "Female",
    phone is 3312820936
     */
    @Test
    public void test1(){
        Response response=given().accept(ContentType.JSON)
                .pathParam("id",10)
                .when().get("/api/spartans/{id}");

        //verify status code
        assertEquals(response.statusCode(),200);
        //verify status code
        assertEquals(response.contentType(),"application/json;charset=UTF-8");
        //printing values
        System.out.println("Id:"+response.body().path("id").toString());
        System.out.println("name"+response.body().path("name").toString());
        System.out.println("gender"+response.body().path("gender").toString());
        System.out.println("phone"+response.body().path("phone").toString());

        int id= response.path("id");
        String name= response.body().path("name");
        String gender =response.body().path("gender");
        String phone = response.body().path("phone");

        System.out.println("id+ "+ id);
        System.out.println("name"+ name);
        System.out.println("gender"+ gender);
        System.out.println("phone"+ phone);

        assertEquals(id,10);
        assertEquals(name,"Lorenza");
        assertEquals(gender,"female");
        assertEquals(phone,"1221213");

    }
    @Test // this is another situations
public void Test2(){

        Response response=get("api/spartans");
        //extract first id
        int firtsId=response.path("id[0]");
        System.out.println("firstID"+ firtsId);

        //extract first name
        String firstname= response.path("name[0]");
        System.out.println("FirstName "+ firstname);

        //get the last name
        String lastName=response.path("name[-1]");
        System.out.println("Last Name "+lastName);

        //extract all firstNames and print them
        List<String>names=response.path("name");
        System.out.println(names);
        System.out.println(names.size() ); // we can also learn size of this list

        //Extract phone numbers
        List<Object> phoneNumbers=response.path("phone");

        for (Object phoneNumber : phoneNumbers){

            System.out.println(phoneNumber);

        }











}







}
