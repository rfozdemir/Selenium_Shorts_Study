package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementByTagName {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        WebElement element=driver.findElement(By.tagName("span"));
        System.out.println(element.getText() );
        List<WebElement> elements=driver.findElements(By.tagName("a"));

driver.close();

    }
}
