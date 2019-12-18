package Summer2019SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class proje24_2 {
    private WebDriver driver;

    @BeforeMethod(description = "As a user, I should be able to send messages by clicking on Message tab under Active Stream")
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://login1.nextbasecrm.com");

        String user= "hr46@cybertekschool.com";
        String password  = "UserUser";

        driver.findElement(By.name("USER_LOGIN")).sendKeys(user);
        driver.findElement(By.name("USER_PASSWORD")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='login-popup']/form/div[2]/input")).click();
        //driver.findElement(By.xpath("//*[@id='feed-add-post-form-tab-message']/span")).click();

    }

    @AfterMethod
    public void teardow (){
       // driver.quit();
    }

    @Test(description = "")
    public void test1(){
        WebElement expectedResult = driver.findElement(By.xpath("//*[@id='feed-add-post-form-tab-message']/span"));
        String actualMessage = expectedResult.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage, "MESSAGE");
        driver.findElement(By.xpath("//*[@id='feed-add-post-form-tab-message']/span")).click();
        BrowserUtils.wait(3);
        driver.switchTo().defaultContent();
//        WebElement inputData = driver.findElement(By.xpath("//*[@id=\"divoPostFormLHE_blogPostForm\"]/div[3]/div[1]"));
//        inputData.sendKeys("Hello Batch 12 \nHello Online 11 \nViva BlueSprint");
       // driver.findElement(By.cssSelector("feed-add-post-text")).sendKeys("Hello Batch 12 \nHello Online 11 \nViva BlueSprint");
        driver.switchTo().defaultContent();
        driver.findElement(By.id("blog-submit-button-save")).click();

    }


}

