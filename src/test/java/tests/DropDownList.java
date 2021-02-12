package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownList {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        //selectByTextTest();
        //selectByValueTest();
        //selectByIndex();
        //  multiSelectDropDownTest();
        nonSelectDropDown();
    }

    public static void setup() {
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    public static void selectByTextTest() {
        setup();
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        driver.close();

    }

    public static void selectByValueTest() {
        setup();
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByValue("DC");
        String expected = "District of Columbia";
        String actual = select.getFirstSelectedOption().getText();
        System.out.println("expected " + expected);
        System.out.println("actual " + actual);
        driver.close();
    }

    public static void selectByIndex() {
        setup();
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByIndex(1);

        String expected = "Alabama";
        String actual = select.getFirstSelectedOption().getText();
        String expectedValue = "AL";
        String actualValue = select.getFirstSelectedOption().getAttribute("value");
        System.out.println("Expected " + expected);
        System.out.println("Actual " + actual);
        System.out.println("Expected Value " + expectedValue);
        System.out.println("Actual Value " + actualValue);
        driver.close();
    }

    public static void multiSelectDropDownTest() {
        setup();
        Select select = new Select(driver.findElement(By.name("Languages")));
        List<WebElement> elements = select.getOptions();
        for (WebElement each : elements) {
            System.out.println(each.getText());

        }
        select.deselectAll();
        driver.close();
    }

    public static void nonSelectDropDown() {
        setup();
        WebElement element1 = driver.findElement(By.id("dropdownMenuLink"));

        // in order to get "option" element you have to click on "element1" element.
        //Because option element is embedded in element1.Otherwise, It will throw exception
        WebElement option = driver.findElement(By.xpath("//a[text()='Amazon']"));
        element1.click();
        option.click();
        driver.close();
    }


}

