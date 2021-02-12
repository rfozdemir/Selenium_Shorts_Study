package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.security.Key;

public class TestNGParametrization {

    // DO NOT FORGET YOU WILL RUN THIS TEST TESTNG.XML FILE, IT WILL PROVIDE YOU PARAMETERS

    @Test
    @Parameters({"email","fullName"})
    public void Test1(@Optional String email,String fullName) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.findElement(By.name("full_name")).sendKeys(email);
        driver.findElement(By.name("email")).sendKeys(fullName, Keys.ENTER);

Thread.sleep(2000);;
driver.quit();
    }

}
