package Homework;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.List;

public class Homework_4 {
    private WebDriver driver;
    private WebDriverWait wait;

    public boolean waitUntilLoaderMaskDisappear(){
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        try{
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='loader-mask shown']")));
            return true;
        } catch (NoSuchElementException e){
            System.out.println("Loader mask not found!");
            e.printStackTrace();
            return true; // no loader mask, all good, return true
        } catch (WebDriverException e){
            e.printStackTrace();
        }
        return false;
    }

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.name("_username")).sendKeys("storemanager85");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.name("_submit")).click();
        //BrowserUtils.wait(2);
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        BrowserUtils.waitForVisibility(activitiesElement,5);
        BrowserUtils.waitForClickablility(activitiesElement,5);
        //BrowserUtils.wait(5);
        activitiesElement.click();
        //BrowserUtils.wait(2);
        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        //BrowserUtils.wait(2);
        calendarEventsElement.click();
        //BrowserUtils.wait(2);
        waitUntilLoaderMaskDisappear();


    }

    @AfterMethod
    public void taeardown() {

       // driver.quit();
    }

    @Test(description = "Verify that 'view', 'edit' and 'delete' options are available")
    public void test1() {
        WebElement threeDots = driver.findElement(By.xpath("//tbody/tr[13]/td[9]/div/div/a"));
        Actions action = new Actions(driver);
        BrowserUtils.waitForVisibility(threeDots,3);
        action.moveToElement(threeDots).perform();
        //BrowserUtils.wait(2);

        WebElement viewElement = driver.findElement(By.xpath("//i[@class='fa-eye hide-text']"));
        BrowserUtils.waitForVisibility(viewElement,3);
        action.moveToElement(viewElement).perform();
        Assert.assertTrue(viewElement.isDisplayed());
        //BrowserUtils.wait(2);

        WebElement editElement = driver.findElement(By.xpath("//i[@class='fa-pencil-square-o hide-text']"));
        BrowserUtils.waitForVisibility(viewElement,3);
        action.moveToElement(viewElement).perform();
        Assert.assertTrue(editElement.isDisplayed());
        //BrowserUtils.wait(2);

        WebElement deleteElement = driver.findElement(By.xpath("//i[@class='fa-trash-o hide-text']"));
        BrowserUtils.waitForVisibility(editElement,3);
        action.moveToElement(editElement).perform();
        Assert.assertTrue(deleteElement.isDisplayed());
        BrowserUtils.wait(2);


    }

    @Test(description = "Verify that 'Title' column still displayed")
    public void test2() {
        WebElement grid = driver.findElement(By.cssSelector("i[class='fa-cog hide-text']"));
        BrowserUtils.waitForVisibility(grid,5);
        BrowserUtils.waitForClickablility(grid,5);
        grid.click();
        List<WebElement> gridList = Driver.get().findElements(By.xpath("//tbody/tr[@class='renderable']/td[3]/input"));
        for(int i = 1; i< gridList.size(); i++){
            gridList.get(i).click();
            Assert.assertFalse(gridList.get(i).isSelected());
        }
    }

    @Test(description = "Verify that 'Save And Close', 'Save And New' and 'Save' options are available")
    public void test3(){
        WebElement createCalendarEvent = driver.findElement(By.cssSelector("a[title='Create Calendar event']"));
        BrowserUtils.waitForVisibility(createCalendarEvent,5);
        BrowserUtils.waitForClickablility(createCalendarEvent,5);
        waitUntilLoaderMaskDisappear();
        createCalendarEvent.click();
        WebElement SaveAndClose = driver.findElement(By.cssSelector("a[class='btn-success btn dropdown-toggle']"));
        SaveAndClose.click();

    }


    @Test(description = "Verify that 'All Calendar Events' page subtitle is displayed")
    public void test4(){
        WebElement createCalendarEvent = driver.findElement(By.cssSelector("a[title='Create Calendar event']"));
        //BrowserUtils.waitForVisibility(createCalendarEvent,5);
        //BrowserUtils.waitForClickablility(createCalendarEvent,5);
        //waitUntilLoaderMaskDisappear();
        createCalendarEvent.click();
    }
    @Test(description = "Verify that difference between end and start time is exactly 1 hour")
    public void test5(){
        driver.findElement(By.xpath("//a[@title=‘Create Calendar event’]")).click();


    }

    @Test(description = "Verify that end time is equals to '10:00 PM' ")
    public void test6(){
        driver.findElement(By.xpath("//a[@title=‘Create Calendar event’]")).click();


    }

    @Test(description = "Verify that start and end date input boxes are displayed")
    public void test7(){
        driver.findElement(By.xpath("//a[@title=‘Create Calendar event’]")).click();


    }

    @Test(description = "Verify that “Daily” is selected by default and following options are available in “Repeats” drop-down")
    public void test8(){
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();


    }

    @Test(description = "Verify that following message as a summary is displayed: Summary: Daily every 1 day")
    public void test9(){
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();


    }

    @Test(description = "Verify that following message as a summary is displayed: Summary: Daily every 1 day, end after 10 occurrences")
    public void test10(){
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();


    }


    @Test(description = "Verify that following message as a summary is displayed: Summary: Daily every 1 day, end by Nov 18, 2021")
    public void test11 () {
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();

    }

    @Test(description = "Verify that “Monday and Friday” options are selected9.Verify that following message as a summary is displayed: “Summary: Weekly every 1 week onMonday, Friday”")
    public void test12 () {
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();

    }

}


