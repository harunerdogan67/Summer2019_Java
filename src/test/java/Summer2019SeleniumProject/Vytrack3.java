package Summer2019SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.Arrays;

public class Vytrack3 {
    public static void main(String[] args) {


        String expectedTitle = "Dashboard";

        String users[] = {"storemanager98", "storemanager99", "storemanager199", "salesmanager261", "salesmanager262"};
        String passwords [] = {"UserUser123"};
        String actualTitle []= new String[users.length];

        for (int i = 0; i < users.length; i++) {
             WebDriver driver = BrowserFactory.getDriver("chrome");
             driver.get("http://qa2.vytrack.com/user/login");
             // driver.manage().window().maximize();
            driver.findElement(By.name("_username")).sendKeys(users[i]);
            driver.findElement(By.name("_password")).sendKeys(passwords[0]);
            WebElement button = driver.findElement(By.id("_submit"));
            button.click();
            BrowserUtils.wait(2);
            System.out.println("Expected Title: " + expectedTitle);
            actualTitle[i] = driver.getTitle();
            System.out.println("Actual Title: " + actualTitle[i]);

            if (expectedTitle.equals(actualTitle[i])) {
                System.out.println(users[i]+" Test Passed");
            }
            else {
                System.out.println(users[i]+" Test Failed!");
            }

            BrowserUtils.wait(2);
            driver.close(); // istersek browseri  acip kapatabiliriz
        }
        System.out.println("\nExpected Title: " + expectedTitle);
        System.out.println("actualTitles: "+Arrays.toString(actualTitle));
    }
}
