package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindByXpath {
    public static void main(String[] args) {
    WebDriver driver= BrowserFactory.getDriver("chrome");
       driver.get("http://practice.cybertekschool.com/");
       WebElement element= driver.findElement(By.xpath("//span[@class='h1y']"));
        System.out.println(element.getText());
        WebElement element1=driver.findElement(By.xpath("//a[.='Context Menu']"));
        //another way of that xpath is "//a[@href="/context_menu"]"
        System.out.println(element1.getText());
        element1.click();
        driver.close();


    }
}
