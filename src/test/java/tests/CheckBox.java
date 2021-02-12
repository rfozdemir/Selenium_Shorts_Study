package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBox {
    public static void main(String[] args) {
        WebDriver driver=BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
//        driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)")).click();
//        driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)")).click();
       //List<WebElement>element=driver.findElements(By.tagName("input"));
        List<WebElement>elements=driver.findElements(By.cssSelector("input[type='checkbox']"));
        for (WebElement each:elements){
            if (!each.isSelected()){
                each.click();
            }
        }
    }
}
