package API_TESTING;


import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import io.restassured.http.ContentType;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;
import static io.restassured.RestAssured.*;


public class DeserializationPojo {
    // we will talk about how can convert our json to our custom java class which is called POJO
    //POJO --> Plain Old Java Object


    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "";

    }

    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON).
                pathParam("id", 12)
                .and().get("");
        response.prettyPrint();

        //how to convert json response to our spartanPOJO class
        //GSON ---> de-serialization
        SpartanPOJO spartan1 = response.body().as(SpartanPOJO.class);
        System.out.println(spartan1.toString());

        //verify each key with spartan object
        assertEquals(spartan1.getName(), "Meta");
        assertEquals(spartan1.getId(), 15);
        assertEquals(spartan1.getGender(), "female");
        assertEquals(spartan1.getPhone(), new Long(1231421));

    }
@Test
    public void gsonExample(){

    Gson gson= new Gson();
    String myJsonBody="{id\": 2,\n" +
            "        \"email\": \"janet.weaver@reqres.in\",\n" +
            "        \"first_name\": \"Janet\",\n" +
            "        \"last_name\": \"Weaver\"}";

    //Using Json method do de serialize our json body
    // I did it by using Gson object
    SpartanPOJO spartanMeta=gson.fromJson(myJsonBody,SpartanPOJO.class);
    System.out.println(spartanMeta.toString());


    //serialization Java object --> Json Body when I use Post method

    SpartanPOJO spartan3=new SpartanPOJO(101,"Mike", "Male",12312307l);
    //converting custom class to json (serialization)
    String jsonbody= gson.toJson(spartan3);


    System.out.println(jsonbody);





}


}
