package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import  org.testng.annotations.Test;
import utilities.BrowserFactory;

public class TestNGPractice {

    @Test
    public void test(){

        Assert.assertEquals("appl","apple","word is not correct! should be apple");

//        before
//        if(str.equals(str2)){
//            System.out.println("Test Passed");
//        }
//        else{
//            System.out.println("Test failed");
//        }
    }

    @Test(description = "Verifying title of the practice website")
    public void verifyTitle(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle, "Title is wrong");

        driver.quit();
    }
    // let's verify that test Automation Practice heading is displayed

    @Test
    public void verifyHeadingIsDisplayed(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        // if there is no element with this locator , we will get NoSuchElemnetException
        //and our program willl stop on the findElement line
       // WebElement heading = driver.findElement((By.xpath("//*[@id=\"content\"]/div/div/h1/span")));
        WebElement heading = driver.findElement((By.xpath("//span[text()='Test Automation Practice']")));
        //to make sure that element is visible  to user
        // bcz element can be presenet, but not visible
        //we need to makes sure element is visible
        // Element is not visible -- will be printed it element is there , but not visible
        //assertTrue - method that check is something is true
        //if it's false , you will get exception
        //.isDisplayed() return true or false
        //if it returns true - that means element is visible
        //if this method returns false - element is not visible
        Assert.assertTrue(heading.isDisplayed(), "Element is not visible");
        driver.quit();
    }
}
