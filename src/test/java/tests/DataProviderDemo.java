package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DataProviderDemo {

    @Test(description = "Verify Page Title",dataProvider ="testData")
    public void Test1(String url,String title){
        WebDriver driver=BrowserFactory.getDriver("chrome");
        driver.get(url);
       //SoftAssert softAssert=new SoftAssert();
       // softAssert.assertTrue(driver.getTitle().contains(title)); IF you want to keep executing you are gonna
        //user Soft assert by using soft assert object or try catch block
            Assert.assertTrue(driver.getTitle().contains(title));
            driver.quit();




    }
    @DataProvider(name="testData")
    public Object [][] test1(){


        return new Object[][]{
                {"http://google.com","Google"},
                {"http://amazon.com","Amazon"},
                {"http://etsy.com","Etsy"},
                {"http://ebay.com","Ebay"},
                {"http://cybertekschool.com","Cybertek"}
        };
    }

}
