import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class GetWebsiteTitle {
    WebDriver driver;
    WebElement element;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver" , "./src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless"); //It means test case run in background and Chrome window doesn't show.
        options.addArguments("--headed"); //It means test case run with the Chrome window.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void getTitle(){
        driver.get("https://intercity.jatriweb.team/");
        String title = driver.getTitle();
        Assert.assertEquals("Jatri Intercity - Login", title); //Expected is the wrong value we set, and title is the actual title of the website.
//        Assert.assertTrue(title.contains("Jatri Intercity - Login"));
    }
    @Test
    public void phoneNumber(){
        driver.get("https://intercity.jatriweb.team/");
        driver.findElement(By.id("phone")).sendKeys("01788090601");
    }

    @Test
    public void password(){
        driver.get("https://intercity.jatriweb.team/");
        driver.findElement(By.id("password")).sendKeys("asdf1234");
    }

    @Test
    public void validUserCredentials(){ //To test successful login

        System.out.println("This is the test code " + new Object(){}.getClass().getEnclosingMethod().getName());
        driver.get("https://intercity.jatriweb.team/");
        driver.findElement(By.xpath("//button[contains(text(),'LOG IN')]")).click();
        driver.findElement(By.id("phonenumber")).sendKeys("01788090601"); //Sending ID
        driver.findElement(By.id("password")).sendKeys("asdf1234"); // Sending PWD
        driver.findElement(By.id("login")).click();
        try{
            element = driver.findElement (By.xpath("//button[contains(text(),'LOG IN')]"));
        }catch (Exception e){
        }
        Assert.assertNotNull(element); //Checking the element presence
        System.out.println("Test End " + new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @Test
    public void WrongUserCredentials()
    {
        System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
        driver.get("https://intercity.jatriweb.team/");
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
        driver.findElement(By.id("log")).sendKeys("01788090602");
        driver.findElement(By.id("pwd")).sendKeys("asdfghjkl"); //Entering wrong pwd
        driver.findElement(By.id("login")).click();
        try{
            element = driver.findElement (By.xpath(".//*[@id='account_logout']/a"));
        }catch (Exception e){
        }
        Assert.assertNotNull(element);
        System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }

//    @After
//    public void finishTitle(){
//        driver.close();
//    }
}
