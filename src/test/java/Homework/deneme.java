package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.BrowserFactory;

public class deneme {




        public static void main(String[] args) {
            // Step 1. Go to "https://www.tempmailaddress.com/"
            // Step 2. Copy and save email as a string.
            // Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
            // Step 4. And click on “Sign Up For Mailing List".
            WebDriver driver= BrowserFactory.getDriver("Chrome");
            driver.get("https://www.tempmailaddress.com/");
            String email= driver.findElement(By.cssSelector("[id='email']")).getText();
            driver.get("http://practice.cybertekschool.com/");
            driver.findElement(By.linkText("Sign Up For Mailing List")).click();
            // Step 5. Enter any valid name.
            // Step 6. Enter email from the Step 2.
            // Step 7. Click Sign UpStep
            // 8. Verify that following message is displayed:
            // “Thank you for signing up. Click the button below to return to the home page.”
            driver.findElement(By.cssSelector("[name='full_name']")).sendKeys("Gamze");
            driver.findElement(By.cssSelector("[name='email']")).sendKeys(email);
            driver.findElement(By.cssSelector("[class='radius']")).click();
            WebElement message=driver.findElement(By.cssSelector("[name='signup_message']"));
            Assert.assertTrue(message.isDisplayed());
            // Step 9. Navigate back to the “https://www.tempmailaddress.com/”
            // Step 10. Verify that you’ve received an
            // email from “do-not-reply@practice.cybertekschool.com”
            // Step 11. Click on that email to open it.
            // Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”
            // Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
            driver.navigate().to("https://www.tempmailaddress.com");
            // BrowserUtils.wait(5);

            //WebElement emailReceived= driver.findElement(By.cssSelector("class ='odMobil']"));
            WebElement emailReceived= driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[1]/td[1]"));

            // LOOKS LIKE THERE IS A BUG IN WEBSITE :))))
            Assert.assertTrue(emailReceived.isDisplayed());
            //driver.findElement(By.cssSelector("[class='odMobil']")).click();
            driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[1]/td[1]")).click();
            String actualEmail= driver.findElement(By.xpath("//*[@id=\"odesilatel\"]")).getText();
            actualEmail = actualEmail.trim();
            String expectedEmail= "do-not-reply@practice.cybertekschool.com";
            Assert.assertEquals(expectedEmail, actualEmail);
            String actualMessage= driver.findElement(By.xpath("//*[@id=\"predmet\"]")).getText();
            String expectedMessage= "Thanks for subscribing to practice.cybertekschool.com!";
            Assert.assertEquals(expectedMessage, actualMessage);
            System.out.println(actualEmail);
            System.out.println(actualMessage);
            driver.quit();
        }
    }

