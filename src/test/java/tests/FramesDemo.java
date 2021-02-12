package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FramesDemo {

    @Test
    public void TestFrame() {
        WebDriver driver=BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/iframe");
       driver.switchTo().frame("mce_0_ifr");
       driver.findElement(By.id("tinymce")).clear();
       driver.findElement(By.id("tinymce")).sendKeys("Test Automation");
       driver.switchTo().defaultContent();
       driver.close();
    }

}
