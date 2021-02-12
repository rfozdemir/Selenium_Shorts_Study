package tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class TestNGDemo2 {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void setup() {
        System.out.println("Before Method");


    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("Test 1");
        String word1 = "java";
        String word2 = "java";
        System.out.println("Test1");
        Assert.assertEquals(word1, word2);
    }

    // @Ignore
    @Test(priority = 2)
    public void test2() {
        System.out.println("Test 2");
        String word1 = "java";
        String word2 = "java";
        System.out.println("Test2");
        Assert.assertEquals(word1, word2);
    }

    @Test(priority = 3)
    public void test3() {
        System.out.println("Test 3");
        Assert.assertTrue(10 > 5);
        throw new SkipException("Just Skipped");  // it will skip that test and just will ignore that test
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }


}
