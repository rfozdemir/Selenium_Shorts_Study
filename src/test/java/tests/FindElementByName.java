package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByName {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement element= driver.findElement(By.name("button2"));
        element.click();
        WebElement element2=driver.findElement(By.id("result"));
        System.out.println(element2.getText());
        driver.close();
    }
}
