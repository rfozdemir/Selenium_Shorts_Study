package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocatorsId {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://www.google.com");

        WebElement element1= driver.findElement(By.id("gbqfbb"));
        String actualText=element1.getAttribute("value");

        String expectedText="I'm Feeling Lucky";
        if(actualText.equals(expectedText)){
            System.out.println("=====Passed=====");
        }else
        {
            System.out.println("failed" );
            System.out.println("Expected Text: "+expectedText);
            System.out.println("Actual Text: "+actualText);
        }

        element1.click();
        Thread.sleep(2000);
        driver.close();




    }
}
