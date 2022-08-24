import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class GetWebsiteTitle {
    WebDriver driver;
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

    @After
    public void finishTitle(){
        driver.close();
    }
}
