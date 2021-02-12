package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestNGDemo {

    @BeforeMethod
    public void setup() {
        System.out.println("Before Method");

    }

    @Test
    public void test1() {
        String word1 = "java";
        String word2 = "java";
        System.out.println("Test1");
        Assert.assertEquals(word1, word2);

    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After Method");
    }

}
