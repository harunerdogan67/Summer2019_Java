package Summer2019SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class proje24_online11 {
    private WebDriver driver;

    @BeforeMethod(description = "As a user, I should be able to send messages by clicking on Message tab under Active Stream")
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://login1.nextbasecrm.com");

        String user= "hr42@cybertekschool.com";
        String password  = "UserUser";

        driver.findElement(By.name("USER_LOGIN")).sendKeys(user);
        driver.findElement(By.name("USER_PASSWORD")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='login-popup']/form/div[2]/input")).click();


    }

    @AfterMethod
    public void teardow (){
        //driver.quit();
    }

    @Test(description = " ")
    public void test1(){
        //driver.findElement(By.xpath("//*[@id='feed-add-post-form-tab-message']")).click();
        //driver.findElement((By.id("//span[@id='bx-b-uploadfile-blogPostForm']"))).click();
       //driver.findElement(By.xpath("//*[@id=\"bx-b-uploadfile-blogPostForm\"]")).click();
       driver.findElement(By.xpath("//span[@class='header-search-icon header-search-icon-title']")).sendKeys("hr41");
        // calismiyor


    }
}
