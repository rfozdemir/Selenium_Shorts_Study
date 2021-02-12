package tests;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class JSExecuterDemo {
    WebDriver driver=BrowserFactory.getDriver("chrome");

    @Test
    public void Test1() throws InterruptedException {
     driver.get("http://practice.cybertekschool.com/");
     WebElement link=driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
Thread.sleep(2000);
js.executeScript("arguments[0].scrollIntoView(true);"+"arguments[0].click()",link);
Thread.sleep(2000);
driver.quit();
    }
}
