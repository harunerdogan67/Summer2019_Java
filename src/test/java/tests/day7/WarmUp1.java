package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;

import java.util.List;

public class WarmUp1{

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://cybertekschool.com/");
        //driver.get(" https://practice-cybertekschool.herokuapp.com"); // ikisi farkli
        //how to find all links?
        //every link as a tag name <a>
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        //List<WebElement> links = driver.findElements(By.xpath("//*[@class=\"list-group-item\"]"));
        //size of the list = number of links
        //findElement vs findElements
        // only one       0 or more element
        //if list is empty, that means that element is not there
        //in this way, we can ensure that element dosen't present
        //  //a[.= 'Home'] or a[text()='Home'] - find link with text Home
        System.out.println("Number of links: " + links.size());
        // what if I want to print text of all links, one by one
        //loop through the colection of links
        for (WebElement webElement : links) {
            //print text of every link
            System.out.println(webElement.getText());
        }






        //driver.quit();



    }
}
