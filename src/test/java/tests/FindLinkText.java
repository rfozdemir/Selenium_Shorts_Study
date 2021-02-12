package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindLinkText {
    public static void main(String[] args) throws InterruptedException {
        // Also there is partial link text don't forget you can use that also if you want and useful

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        List<WebElement> elements=driver.findElements(By.tagName("a"));
        System.out.println(elements.size());


        WebElement element=driver.findElement(By.linkText("Autocomplete"));
        element.click();


        //Thread.sleep(3000);
        driver.close();



    }
}
