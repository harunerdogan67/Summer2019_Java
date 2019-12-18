package tests.day8;

//import com.sun.org.apache.bcel.internal.generic.Select;
// bunu yukleyince  (import org.openqa.selenium.support.ui.Select;) calismiyor
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.List;

public class Dropdowns {
    private WebDriver driver;
    //private because it will be used only in this class

//    <select id="dropdown">
//      <option value="" disabled="disabled" selected="selected">Please select an option</option>
//      <option value="1">Option 1</option>
//      <option value="2">Option 2</option>
//    </select>

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
//       <a href="/dropdown">Dropdown</a>
        driver.findElement(By.linkText("Dropdown")).click();
    }

    @Test(description = "Select option 2 from the dropdown")
    public void test1(){
        // to work with select dropdowns, we need to use Select class in Selenium
        //step 1. Find dropdown and create a webelement
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //ste 2. Create a select object
        //select class requires webelemnt object as a parameter
        Select select = new Select(dropdown);
        //to select any option by visible text:
        select.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        //how to verify that option 2 is selected
        //select.getFirstSelectedOption() - to get selected option
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
    }

    @Test(description = "print list of states")
    public void test2(){
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
        List<WebElement> states = select.getOptions();
        //how to print every option, as a text, one by one?
        for(WebElement option: states){
            System.out.println(option.getText());
        }

    }

    @Test(description = "Selec your state and verify that state is selected")
    public void test3(){
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
        //<option value="MO">Missouri</option>
        //we can use tes, value or index for selection
        select.selectByValue("MO");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Missouri");

    }


    @AfterMethod
    public void teardow(){
        driver.quit();
    }

}
