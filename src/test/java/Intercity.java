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
import java.util.List;

public class Intercity {
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
    public void writeText(){
        driver.get("https://intercity.jatriweb.team/");
//        driver.findElement(By.id("phone")).sendKeys("01788090601"); //using id
//        driver.findElement(By.cssSelector("[type = text]")).sendKeys("01788090601"); //using type
//        driver.findElement(By.cssSelector("[id = phone]")).sendKeys("01788090601"); //using id=phone
//        driver.findElement(By.className("form-control")).sendKeys("01788090601"); //-->using class name
        WebElement txtPhone = driver.findElement(By.id("phone"));
        txtPhone.sendKeys("01788090601");
//        WebElement passwordPassword = driver.findElement(By.id("password"));
//        txtPhone.sendKeys("aassdf1234");
//        WebElement passwordPassword = driver.findElement(By.xpath("//input[@id='password']"));
//        passwordPassword.sendKeys("asdf1234");
        WebElement passwordPassword = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordPassword.sendKeys("asdf1234");

//        List <WebElement> button = driver.findElements(By.tagName("button"));
//        button.get(0).click(); //[User Login Check]

    }

    @Test
    public void loginWithValidCredential(){
        driver.get("https://intercity.jatriweb.team/");
        WebElement txtPhone = driver.findElement(By.id("phone"));
        txtPhone.sendKeys("01788090601");
        WebElement passwordPassword = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordPassword.sendKeys("asdf1234");
        List <WebElement> button = driver.findElements(By.tagName("button"));
        button.get(0).click();
    }

    @Test
    public void loginWithInValidCredential(){
        driver.get("https://intercity.jatriweb.team/");
        WebElement txtPhone = driver.findElement(By.id("phone"));
        txtPhone.sendKeys("01789090601");
        WebElement passwordPassword = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordPassword.sendKeys("12345678");
        List <WebElement> button = driver.findElements(By.tagName("button"));
        button.get(0).click();
        System.out.println("=====> You Enter Invalid User Credential <=====");
    }

    @Test
    public void Dashboard(){
        driver.get("https://intercity.jatriweb.team/admin/dashboard");
        String title = driver.getTitle();
        Assert.assertEquals("Jatri Intercity - Dashboard", title);
    }
    @Test
    public void dashboardView() {
        driver.get("https://intercity.jatriweb.team/");
        WebElement txtPhone = driver.findElement(By.id("phone"));
        txtPhone.sendKeys("01788090601");
        WebElement passwordPassword = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordPassword.sendKeys("asdf1234");
        List<WebElement> button = driver.findElements(By.tagName("button"));
        button.get(0).click();
        driver.get("https://intercity.jatriweb.team/admin/dashboard");
        String title = driver.getTitle();
        Assert.assertEquals("Jatri Intercity - Dashboard", title);
    }

//    @After
//    public void finishTitle(){
//        driver.close();
//    }
}
