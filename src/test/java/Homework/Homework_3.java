package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class Homework_3 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.name("_username")).sendKeys("storemanager85");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.name("_submit")).click();
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        BrowserUtils.wait(5);
        activitiesElement.click();
        BrowserUtils.wait(2);
        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        BrowserUtils.wait(2);
        calendarEventsElement.click();
        BrowserUtils.wait(2);

    }

    @AfterMethod
    public void taeardown() {

        //driver.quit();
    }

    @Test(description = "Verify that page subtitle 'Options' is displayed")
    public  void test1(){
//        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
//        BrowserUtils.wait(5);
//        activitiesElement.click();
//        BrowserUtils.wait(2);
//        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
//        BrowserUtils.wait(2);
//        calendarEventsElement.click();
        BrowserUtils.wait(2);
        String expectedResult = "Options";
        WebElement options = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/div/div/div[2]/div"));
        String actualResult = options.getText();
        Assert.assertEquals(actualResult,expectedResult);
        System.out.println(actualResult);
    }
    @Test(description = "Verify that page number is equals to '1'")
    public  void test2(){
        BrowserUtils.wait(2);
        String expectedResult = "1";
        //WebElement num1 = driver.findElement(By.xpath("//div[2]/div[1]/div/div[4]/ul/li[2]"));
        //WebElement num1 = driver.findElement(By.cssSelector("input[value='1']"));
        WebElement num1 = driver.findElement(By.cssSelector("input[type='number']"));
        //WebElement num1 = driver.findElement(By.xpath("//input[@value='1']"));
        //WebElement num1 = driver.findElement(By.xpath("//input[@type='number']"));
        BrowserUtils.wait(2);
        String actualResult = num1.getText();
        System.out.println("expectedResult: "+expectedResult);
        System.out.println("actualResult: "+num1.getText());
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(description = "Verify that view per page number is equals to '25'")
    public void test3(){
        BrowserUtils.wait(2);
        String expectedResult = "25";
        WebElement num1 = driver.findElement(By.xpath("//div[@class='grid-toolbar clearfix']/div[3]/div[2]/div/div/button"));
        BrowserUtils.wait(2);
        String actualResult = num1.getText();
        System.out.println("expectedResult: "+num1.getText());
        System.out.println("actualResult: "+num1.getText());
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test(description = "Verify that number of calendar events (rows in the table) is equals to number of records")
    public void test4(){
        WebElement record = driver.findElement(By.xpath("//html//div[2]/div[1]/div/div[4]/label[3]"));
        BrowserUtils.wait(3);
        Assert.assertTrue(record.isDisplayed());
        System.out.println(record.getText());

    }
    @Test(description = "Verify that all calendar events were selected")
    public void test5(){
        WebElement title = driver.findElement(By.xpath("//div[2]/div[2]/div[2]/div/table/thead/tr/th[1]/div/button/input"));
        BrowserUtils.wait(2);
        title.click();
        BrowserUtils.wait(2);
        Assert.assertTrue(title.isSelected());
     }

    @Test(description = "Verify the testers meeting information")
    public void test6() {
        String[] xpath = {"\"//div[text()='Testers meeting']\"", "\"//div[text()='This is a a weekly testers meeting']\"",
                "\"//div[text()='Nov 27, 2019, 9:30 AM']\"", "\"//div[text()='Nov 27, 2019, 10:30 AM']\"", "\"//div[text()='No']\"",
                "\"//div[@class='calendar-event-organizer']/a\"", "\"//span[@class='list-group-item-text']/a\"",
                "\"//div[text()='Weekly every 1 week on Wednesday']\"", "\"//label[text()='Call via Hangout']/parent::div/div/div\""};
        // ayse turk ablanin yazdigi xpathler

        String[] expectedResult = {"Testers meeting", "This is a a weekly testers meeting", "Nov 27, 2019, 9:30 AM",
                "Nov 27, 2019, 10:30 AM", "No", "Stephan Haley", "Tom Smith", "Weekly every 1 week on Wednesday", "No"};

//        for (int i = 0; i < 9; i++) {
//            System.out.println(xpath[i] +" "+expectedResult[i]);
//        }

        for (int i = 0; i < 9; i++) {
            BrowserUtils.wait(2);
            WebElement eleman = driver.findElement(By.xpath(xpath[i]));
            BrowserUtils.wait(2);
            Assert.assertEquals(eleman.getText(), expectedResult[i]);
            System.out.println(eleman.getText());
        }
    }







}
