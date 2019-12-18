package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class FileUpload {
    private WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
       // driver.manage().window().maximize();
    }

    @Test
    public void test1(){
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("/Users/harunerdogan/Desktop/javaengers/java ders notlari/day52 class note.txt");
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(4);

        String expectedFileName = "day52 class note.txt";
        String  actualFileName = driver.findElement(By.xpath("//*[@id=\"uploaded-files\"]")).getText();
        System.out.println(driver.findElement(By.id("uploaded-files")).getText());
        Assert.assertEquals(actualFileName, expectedFileName, "Subject is correct");

    }


    @AfterMethod
    public void teardown(){
        //driver.quit();
    }
}
