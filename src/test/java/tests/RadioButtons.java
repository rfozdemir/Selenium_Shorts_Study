package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
//        WebElement element1 = driver.findElement(By.xpath("//label[text()='Yellow']/preceding-sibling::input"));
//        element1.click();
//        System.out.println(element1.isEnabled());
//        WebElement element2 = driver.findElement(By.id("green"));
//        element2.click();
//        System.out.println(element2.isEnabled());
        List<WebElement> elements= driver.findElements(By.cssSelector("input[type='radio']"));
        for(WebElement each: elements){
            System.out.println(each.getAttribute("id")+" - "+each.isEnabled());
        }

        driver.close();


    }
}
