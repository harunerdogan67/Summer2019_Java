package OfisSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationFormTests {

    public static void main(String[] args) {
        //to setup webdriver
        //without webdriver, out test will not run
        //we cannot connect with a browser without it
        WebDriverManager.chromedriver().setup();
        //we must create webdriver object first,
        //before any interactions
        WebDriver driver = new ChromeDriver();
        //to open a website
        driver.get("http://practice.cybertekschool.com");
        //<a href="/registration_form">Registration Form</a>
        // a - it's a tag name, that is used to create hyperlinks
        // href - it's an attribute that describes destination page
        // whatever is in between >text< calls link text
        // Registration Form - is a link text
        WebElement element = driver.findElement(By.linkText("Registration Form"));
        //then we can click on the element
        element.click();
        //enter first name
        driver.findElement(By.name("firstname")).sendKeys("Some TestUser");
        ////*[text()='Home']
        // //tag[text()='']
        // contains is for partial text/value
        // it's useful for dynamic elements, when some values are partially change
        //  //tag[contains(text(),'Text')] or  //*[contains(text(),'Text')]
        // //tag[contains(@attribute, 'Value')] or //*[contains(@attribute, 'Value')]
        driver.findElement(By.xpath("//input[@placeholder='last name']")).sendKeys("MyLastName");
        driver.findElement(By.cssSelector("[placeholder='username']")).sendKeys("username");
        //driver.quit();
    }
}
