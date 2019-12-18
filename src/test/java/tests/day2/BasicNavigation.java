package tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class BasicNavigation {
    public static void main(String[] args) {
        //we have to setup webdriver based on the browser that we gonna use
        WebDriverManager.chromedriver().setup();
        //we need to create an object of appropriate class
        ChromeDriver driver = new ChromeDriver();
        //let's open google.com
        //.get() method allows to open some website
        driver.get("http://google.com");

        driver.navigate().to("http://amazon.com");

        driver.navigate().back();

        String url = driver.getCurrentUrl();
        System.out.println(url);

    }
}