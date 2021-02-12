package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

public class FindByCSS {
    public static void main(String[] args) {
       WebDriver driver= BrowserFactory.getDriver("chrome");
       driver.get("http://practice.cybertekschool.com/registration_form");
        WebElement element1=driver.findElement(By.cssSelector("input[name='firstname']"));
        element1.sendKeys("Furkan");
        WebElement element2=driver.findElement(By.cssSelector("input[name='lastname']"));
        element2.sendKeys("Ozdemir");
        WebElement element3=driver.findElement(By.cssSelector("input[name='username']"));
        element3.sendKeys("furkan94");
        WebElement element4=driver.findElement(By.cssSelector("input[name='email']"));
        element4.sendKeys("frkn@gmail.com");
        WebElement element5=driver.findElement(By.cssSelector("input[name='password']"));
        element5.sendKeys("fff1121@..!");
        WebElement element7=driver.findElement(By.cssSelector("input[name='birthday']"));
        element7.sendKeys("01/01/1994");
        WebElement element8=driver.findElement(By.cssSelector("input[name='phone']"));
        element8.sendKeys("619-111-1111");

        WebElement element9=driver.findElement(By.cssSelector("input[value='male']"));
        element9.click();
        Select select=new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        select.selectByVisibleText("SDET");

        WebElement element6=driver.findElement(By.id("wooden_spoon"));
        element6.click();
        driver.quit();





        //driver.close();
    }
}
