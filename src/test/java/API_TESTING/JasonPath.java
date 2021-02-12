package API_TESTING;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.jsoup.Connection;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JasonPath {

    @BeforeClass
    public void setup(){
        RestAssured.baseURI="asd";

    }


    @Test
    public void test1(){
        Response response= RestAssured.given().accept(ContentType.JSON)
                .pathParam("id",11)
                .when().get("/api/spartans/{id}");

        Assert.assertEquals(response.statusCode(),200);

        //how to read value with jasonPath

        JsonPath jsonData=  response.jsonPath();
        int id=jsonData.getInt("id");
        String name=jsonData.getString("name");
        String gender=jsonData.getString("gender");
        long phone=jsonData.getLong("phone");

        //verify json payload with JsonPath
        Assert.assertEquals(id,11);
        Assert.assertEquals(name,"Nona");
        Assert.assertEquals(gender,"female");
        Assert.assertEquals(phone,012344566);





    }
}
