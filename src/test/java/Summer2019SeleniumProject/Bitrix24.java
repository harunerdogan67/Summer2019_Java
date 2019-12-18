package Summer2019SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class Bitrix24 {
    public static void main(String[] args) {

    String expectedTitle = "Portal";

    String users[] = {"helpdesk45@cybertekschool.com",
            "helpdesk46@cybertekschool.com",
            "marketing45@cybertekschool.com",
            "marketing46@cybertekschool.com",
            "hr45@cybertekschool.com",
            "hr46@cybertekschool.com"};

    String passwords [] = {"UserUser"};
        for (int i = 0; i < users.length; i++) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://login1.nextbasecrm.com");

        WebElement input = driver.findElement(By.name("USER_LOGIN"));
        input.sendKeys(users[i]);
        WebElement input2 = driver.findElement(By.name("USER_PASSWORD"));
        input2.sendKeys(passwords[0]);
        WebElement button = driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[2]/input"));
        button.click();
        BrowserUtils.wait(2);

        System.out.println("Expected Title: " + expectedTitle);
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title: " + actualTitle);

        if (expectedTitle.equals(actualTitle)) {
            System.out.println(users[i]+" Test Passed");
        }
        else {
            System.out.println(users[i]+" Test Failed!");
        }

        BrowserUtils.wait(2);
        driver.close(); // istersek browseri  acip birakabiliriz
    }
}
}
