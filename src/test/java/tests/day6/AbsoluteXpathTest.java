package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class AbsoluteXpathTest {

    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://login1.nextbasecrm.com/");

        driver.findElement(By.className("login-btn")).click();
        BrowserUtils.wait(2);
            // xpath yazma konusunda asagidaki 3'u de calisiyor
        //WebElement warningMessage = driver.findElement((By.xpath("//*[@id=\"login-popup\"]/div[2]")));
            // bu xpath i htmlden kopyaladik
        //WebElement warningMessage = driver.findElement((By.xpath("/html/body/table/tbody/tr[2]/td/div/div/div[2]")));
        //yukaradaki absolute xpath olarak adlandiriliyor html uzerinden yazildigi icin zaman icinde degisebilir
        // bu xpath i kendimiz yazdik Vasyl nin anlattigi gibi
        WebElement warningMessage = driver.findElement((By.xpath("//div[@class='errortext']")));
            // bu xpath i kendimiz yazdik Ayse ablanin anlattigi gibi

        System.out.println(warningMessage.getText());

        //driver.quit();

    }

}
