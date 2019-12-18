package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;

public class BitrixLogin {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/");

        String user= "helpdesk41@cybertekschool.com";
        String password  = "UserUser";
        //driver.findElement(By.name("USER_LOGIN")).sendKeys(user);
        //driver.findElement(By.xpath("//input[@placeholder='Login']")).sendKeys(user);
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(user);

        //driver.findElement((By.name("USER_PASSWORD"))).sendKeys(password);
        //driver.findElement((By.xpath("//input[@placeholder='Password']"))).sendKeys(password);
        driver.findElement((By.xpath("//input[@name='USER_PASSWORD']"))).sendKeys(password);

        driver.findElement(By.xpath("//input[starts-with(@onclick, 'BX')]")).click();
        //driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[2]/input")).click();
        //driver.findElement(By.xpath("//input[starts-with(@value, 'Log')]")).click();





    }
}
