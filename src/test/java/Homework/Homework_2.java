package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class Homework_2 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
    }

    @AfterMethod
    public void taeardown() {

        driver.quit();
    }


    @Test
    public void test1() {

        WebElement element = driver.findElement(By.linkText("Registration Form"));
        element.click();
        WebElement input = driver.findElement(By.name("birthday"));
        input.sendKeys("wrong_dob");
        WebElement display = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/small[2]"));


        Assert.assertTrue(display.isDisplayed(), "The date of birth is not valid");


    }

    @Test
    public void test2() {

        WebElement element = driver.findElement(By.linkText("Registration Form"));
        element.click();

        WebElement inlineCheckbox1 = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[11]/div/div[1]/label"));
        Assert.assertTrue(inlineCheckbox1.isDisplayed(), "C++");

        WebElement inlineCheckbox2 = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[11]/div/div[2]/label"));
        Assert.assertTrue(inlineCheckbox2.isDisplayed(), "Java");

        WebElement inlineCheckbox3 = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[11]/div/div[3]/label"));
        Assert.assertTrue(inlineCheckbox3.isDisplayed(), "JavaScript");

    }

    @Test
    public void test3() {

        WebElement element = driver.findElement(By.linkText("Registration Form"));
        element.click();
        WebElement firstname = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/input"));
        firstname.sendKeys("A");

        WebElement display = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[2]"));

        Assert.assertTrue(display.isDisplayed(), "first name must be more than 2 and less than 64 characters long");

    }

    @Test
    public void test4() {

        WebElement element = driver.findElement(By.linkText("Registration Form"));
        element.click();
        WebElement lastname = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/input"));
        lastname.sendKeys("S");

        WebElement display = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[2]"));

        Assert.assertTrue(display.isDisplayed(), "The last name must be more than 2 and less than 64 characters long");

    }

    @Test
    public void test5() {

        WebElement element = driver.findElement(By.linkText("Registration Form"));
        element.click();

        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("Ibrahim");
        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("Ismail");
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Musa1234");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("mail@ismail.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Isa123456");
        WebElement phonenumber = driver.findElement(By.name("phone"));
        phonenumber.sendKeys("555-123-4567");

        WebElement gender = driver.findElement(By.cssSelector("#registrationForm > div:nth-child(7) > div > div:nth-child(1) > label"));
        System.out.println(gender.getText());
        gender.click();


        WebElement birth = driver.findElement(By.name("birthday"));
        birth.sendKeys("01/01/1951");
        WebElement depertment = driver.findElement(By.cssSelector("#registrationForm > div:nth-child(9) > div > select > option:nth-child(2)"));
        depertment.click();
        WebElement jobtitle = driver.findElement(By.cssSelector("#registrationForm > div:nth-child(10) > div > select > option:nth-child(4)"));
        jobtitle.click();
        WebElement language = driver.findElement(By.cssSelector("#inlineCheckbox2"));
        language.click();
        WebElement signupbtn = driver.findElement(By.id("wooden_spoon"));
        signupbtn.click();
        WebElement p = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/p"));

        Assert.assertTrue(p.isDisplayed(), "You've successfully completed registration!");

    }

    @Test(description = "Verify that you’ve received an email and verify that subject is: Thanks for subscribing to practice.cybertekschool.com!")
    public void test6 () {
        driver.get("https://www.tempmailaddress.com/");
        String datamail = driver.findElement(By.id("email")).getText();
        BrowserUtils.wait(2);

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("Hech");
        driver.findElement(By.name("email")).sendKeys(datamail);
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtils.wait(2);

        WebElement actualResult = driver.findElement(By.name("signup_message"));
        Assert.assertTrue(actualResult.isDisplayed(), "Thank you for signing up. Click the button below to return to the home page.");
        BrowserUtils.wait(2);

        driver.get("https://www.tempmailaddress.com/");
        WebElement fromEmail = driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[1]/td[1]"));

        String ExpectedEmail = "do-not-reply@practice.cybertekschool.com";
        String ActualEmail = fromEmail.getText();
        ActualEmail = ActualEmail.trim();//mail adresi onundeki varsa bosluklari kirpmak icin (basta bosluk var)

        Assert.assertEquals(ActualEmail, ExpectedEmail, "Email is not receved");
        fromEmail.click();
        BrowserUtils.wait(2);

        String ExpectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        String ActualSubject = driver.findElement(By.id("predmet")).getText();
        Assert.assertEquals(ActualSubject, ExpectedSubject, "Subject line is not correct");
        System.out.println(ActualSubject);
        BrowserUtils.wait(2);

    }

    @Test(description = "Upload any file with .txt extension from your computer.")
    public void test7 () {
        //driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.name("file")).sendKeys("/Users/harunerdogan/Desktop/class notes.txt");
        BrowserUtils.wait(3);// yukarda tanimlanan yol ile bilgisayardan txt dosya yuklemeli?
        driver.findElement(By.id("file-submit")).click();
        String ExpectedSubject = "File Uploaded!";
        String ActualSubject = driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText();
        String fileName = driver.findElement(By.id("uploaded-files")).getText();
        System.out.println("File Name: " + fileName);
        Assert.assertEquals(ActualSubject, ExpectedSubject, "Subject is not correct");


    }

    @Test(description = "Verify that following message is displayed: You selected: United States of America ")
    public void test8 () {
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.name("myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        WebElement inputCountry = driver.findElement(By.id("result"));
        Assert.assertTrue(inputCountry.isDisplayed(), "United States of America");


    }

//    @Test(description = "Status Codes 200")
//    public void test9 () {
//        driver.findElement(By.linkText("Status Codes")).click();
//        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/a")).click();
//        String actualStatus = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
//        Assert.assertTrue(actualStatus.contains("This page returned a 200 status code"));
//        System.out.println(actualStatus);
//    }
//
//    @Test(description = "Status Codes 301")
//    public void test10 () {
//        driver.findElement(By.linkText("Status Codes")).click();
//        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/a")).click();
//        String actualStatus = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
//        Assert.assertTrue(actualStatus.contains("This page returned a 301 status code"));
//        System.out.println(actualStatus);
//    }
//
//    @Test(description = "Status Codes 404")
//    public void test11 () {
//        driver.findElement(By.linkText("Status Codes")).click();
//        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/a")).click();
//        String actualStatus = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
//        Assert.assertTrue(actualStatus.contains("This page returned a 404 status code"));
//        System.out.println(actualStatus);
//    }
//
//    @Test(description = "Status Codes 500")
//    public void test12 () {
//        driver.findElement(By.linkText("Status Codes")).click();
//        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[4]/a")).click();
//        String actualStatus = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
//        Assert.assertTrue(actualStatus.contains("This page returned a 500 status code"));
//        System.out.println(actualStatus);
//    }


    // test 9,10,11,12
    @DataProvider(name = "statusCode")
    public static Object[] statusCode () {
        return new Object[]{"200", "301", "404", "500"};
        //oblect 1 boyutlu olmasi yeterli cunku ayni page de farkli kodlara click yapacagiz
    }

    @Test(dataProvider = "statusCode")
    public void test13 (String statusCode){
        driver.findElement(By.linkText("Status Codes")).click();
        WebElement statusCodeNumber = driver.findElement(By.linkText(statusCode));
        //status kodlari yukardaki object arrayden alip burda click ediyoruz
        statusCodeNumber.click();
        WebElement result = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(result.getText().contains(statusCode), "Wrong Error code");
        //status kod number beklenen result ta yoksa false veriyor testte kaliyoruz
        // varsa testi geciyoruz
        System.out.println(result.getText());

    }


}

