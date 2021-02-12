package API_TESTING;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;

import static org.testng.Assert.*;

import static io.restassured.RestAssured.*;

public class deserialization1 {

    // we will user for deserialization
    //JSON --> Java collections
    //Json Parser, Object Mappers
    //GSON
    //Jackson 1.x
    //Jackson 2.x
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/api/users/2";

    }

    @Test
    public void test1() {

        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 2).and()
                .when().get("/api/users/{id}");

        //convert Json response to Java Collections (Map)
        Map<String, Object> spartanMap = response.body().as(Map.class);
        System.out.println(spartanMap.get("id"));
        System.out.println(spartanMap.get("first_name"));
        System.out.println(spartanMap.get("data"));

        assertEquals(spartanMap.get("name"), "Nona");

    }

    @Test
    public void Test2() {
        //This time we will covert full json body to List with key and value format
        //If have more than one body we should use this way
        Response response= given().accept(ContentType.JSON)
                .when().get("/api/spartans");
        response.prettyPrint();

        //convert full json body to list of maps

        List<Map<String,Object>> listOfSpartans = response.body().as(List.class);


        //print all data of first spartan
        System.out.println(listOfSpartans.get(0));//so we can get datas of first spartan according to index number
        Map<String,Object>firstSpartan=listOfSpartans.get(0);
        System.out.println(firstSpartan.get("name"));


        //if we wanna see all spartans one by one we can use for loop
        //you can use them in base on your test case

        int count=0;
        for(Map<String,Object> each : listOfSpartans  )  {
            System.out.println(count +" - spartan "+ each);
            count++;
        }




    }


}
