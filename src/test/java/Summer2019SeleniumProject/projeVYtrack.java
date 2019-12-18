package Summer2019SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class projeVYtrack {
    public static void main(String[] args) {

        String expectedTitle = "Dashboard";

        String users[] = {"storemanager98", "storemanager99", "storemanager199", "salesmanager261", "salesmanager262"};

        for (int i = 0; i < users.length; i++) {

            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get("http://qa2.vytrack.com/user/login");

            WebElement input = driver.findElement(By.name("_username"));
            input.sendKeys(users[i]);

            WebElement input2 = driver.findElement(By.name("_password"));
            input2.sendKeys("UserUser123");

            WebElement button = driver.findElement(By.id("_submit"));
            button.click();
            BrowserUtils.wait(2);

            System.out.println("Expected Title: " + expectedTitle);
            String actualTitle = driver.getTitle();
            System.out.println("Actual Title: " + actualTitle);



            if (expectedTitle.equals(actualTitle)) {
                System.out.println(users[i]+" Test Passed");
            } else {
                System.out.println(users[i]+" Test Failed!");
            }

            BrowserUtils.wait(2);
            //driver.close(); // istersek acip browseri kapatabiliriz
        }
    }
}
