package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;

public class EnterTextPractice {

    public static void main(String[] args) {
        //grey text "browser" is not a value
        //it's a placeholder/ or name of the method parameter
        //you dn't enter that
        //it comes up automatically
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement inputBox = driver.findElement(By.name("email"));
        //we enter the text
        inputBox.sendKeys("random@email.com");
        WebElement button = driver.findElement(By.id("form_submit"));
        //to click on the element
        button.click();
        String expectedUrl = "http://practice.cybertekschool.com/email-sent";
        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        if (expectedUrl.equals(actualUrl)){
            System.out.println("Test Passed");
        }
        else{
            System.out.println("Test Failed");
        }





        //BrowserUtils.wait(2);
       // driver.close();
    }
}
