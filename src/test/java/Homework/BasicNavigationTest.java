package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;
import java.util.List;

public class BasicNavigationTest {
    private WebDriver driver;
    @BeforeTest
    public  void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice-cybertekschool.herokuapp.com");
    }
    @AfterTest
    public  void taeardown() {

        driver.quit();
      }
    @Test(description = "Thank you for signing up. Click the button below to return to the home page")
    public void test1(){
        BrowserUtils.wait(3);
        String expectedResult1 = "Thank you for signing up. Click the button below to return to the home page.";
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("is-mail");
        driver.findElement(By.name("email")).sendKeys("is-mail@ismail.com");
        driver.findElement(By.name("wooden_spoon")).click();
        WebElement Result1 = driver.findElement(By.name("signup_message"));
        String actualResult1 = Result1.getText();
        System.out.println("Expected Result: "+expectedResult1);
        System.out.println("Actual Result: "+actualResult1);
        if (actualResult1.equals(expectedResult1)){
            System.out.println("Test1 Passed");
        }
        else{
            System.out.println("Test1 Failed!");
        }

    }
    @Test(description = "Verify that number of listed examples is equals to 48.")
    public void test2(){
        BrowserUtils.wait(3);
        int expectedResult2 = 48;
                List<WebElement> list=  driver.findElements(By.className("list-group-item"));
        int actualResult2  = list.size();
        System.out.println(actualResult2);
        if (actualResult2 == expectedResult2){
            System.out.println("Test2 Passed");
        }
        else{
            System.out.println("Test2 Failed!");
        }

    }



    @Test(description = "Clicked on button one!")
    public void test3(){
        BrowserUtils.wait(3);
        String expectedResult3 = "Clicked on button one!";
        driver.findElement(By.linkText("Multiple Buttons")).click();
        driver.findElement(By.xpath("//*[@id='content']/div[1]/button[1]")).click();
        WebElement Result3 = driver.findElement(By.id("result"));
        String actualResult3 = Result3.getText();
        System.out.println(actualResult3);
        if (actualResult3.equals(expectedResult3)){
            System.out.println("Test3 Passed");
        }
        else{
            System.out.println("Test3 Failed!");
        }

    }
    @Test
    public void test45678(){
        BrowserUtils.wait(3);
        String expectedResult4 = "first name can only consist of alphabetical letters";
        WebElement element4 = driver.findElement(By.linkText("Registration Form"));
        element4.click();
        BrowserUtils.wait(1);
        driver.findElement(By.name("firstname")).sendKeys("123");
        WebElement result4 = driver.findElement(By.xpath("//*[@id='registrationForm']/div[1]/div/small[3]"));
        String actualResult4=result4.getText();
        System.out.println("Expected Result: "+expectedResult4);
        System.out.println("Actual Result: "+actualResult4);
        if (actualResult4.equals(expectedResult4)){
            System.out.println("Test4 Passed");
        }
        else{
            System.out.println("Test4 Failed!");
        }
// test case 5
        BrowserUtils.wait(3);
        String expectedResult5 = "The last name can only consist of alphabetical letters and dash";
        driver.findElement(By.name("lastname")).sendKeys("123");
        WebElement result5 = driver.findElement(By.xpath("//*[@id='registrationForm']/div[2]/div/small[3]"));
        String actualResult5 = result5.getText();
        System.out.println("Expected Result: " + expectedResult5);
        System.out.println("Actual Result: " + actualResult5);
        if (actualResult5.equals(expectedResult5)) {
            System.out.println("Test5 Passed");
        } else {
            System.out.println("Test5 Failed!");
        }
// test case 6
        BrowserUtils.wait(3);
        String expectedResult6 = "The username must be more than 6 and less than 30 characters long";
        driver.findElement(By.name("username")).sendKeys("user");
        WebElement result6 = driver.findElement(By.xpath("//*[@id='registrationForm']/div[3]/div/small[2]"));
        String actualResult6=result6.getText();
        System.out.println("Expected Result: "+expectedResult6);
        System.out.println("Actual Result: "+actualResult6);
        if (actualResult6.equals(expectedResult6)){
            System.out.println("Test6 Passed");
        }
        else{
            System.out.println("Test6 Failed!");
        }
// test case 7
        BrowserUtils.wait(3);
        String expectedResult7 = "email address is not a valid or Email format is not correct";
        driver.findElement(By.name("email")).sendKeys("testers@email");
        WebElement result70 = driver.findElement(By.xpath("//*[@id='registrationForm']/div[4]/div/small[2]"));
        WebElement result71 = driver.findElement(By.xpath("//*[@id='registrationForm']/div[4]/div/small[3]"));
        // actualResult7 ==> resault 70 and result 71 2 difrent object
        System.out.println("Expected Result: "+expectedResult7);
        System.out.println("Actual Result: "+result70.getText());
        System.out.println("Actual Result: "+result71.getText());
        // String actualResult7=result70.getText()+" "+result71.getText(); //  you can use if you want but change "if"statement
        if (expectedResult7.contains(result70.getText())||expectedResult7.contains(result71.getText())){
            //if (expectedResult7.equals(actualResult7)){   //  you can use if you want
            System.out.println("Test7 Passed");
        }
        else{
            System.out.println("Test7 Failed!");
        }
// test case 8
        BrowserUtils.wait(3);
        String expectedResult8 = "Phone format is not correct";
        driver.findElement(By.name("phone")).sendKeys("5711234354");
        WebElement result8 = driver.findElement(By.xpath("//*[@id='registrationForm']/div[6]/div/small[2]"));
        String actualResult8=result8.getText();
        System.out.println("Expected Result: "+expectedResult8);
        System.out.println("Actual Result: "+actualResult8);
        if (actualResult8.equals(expectedResult8)){
            System.out.println("Test8 Passed");
        }
        else{
            System.out.println("Test8 Failed!");
        }

    }
}
