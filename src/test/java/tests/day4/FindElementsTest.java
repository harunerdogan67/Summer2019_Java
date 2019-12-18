package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class FindElementsTest {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        // Step 1. Open inspector in chrome and find locator for the element
        // Step 2. Create object of WebElement
        // Step 3. Use webelement

        String expectedTitle = driver.getTitle();
        System.out.println("Expected Title: "+expectedTitle);

        WebElement button = driver.findElement(By.id("form_submit"));
        //to click on the element
        button.click();
        BrowserUtils.wait(2);

        String actualTitle = driver.getTitle();
        System.out.println("Actual Title: "+actualTitle);

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Test Passed");
        }
        else{
            System.out.println("Test Failed");
        }

        driver.close();
    }
}
